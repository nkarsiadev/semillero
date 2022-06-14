using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace Api_db.Models
{
    public partial class bancoContext : DbContext
    {
        public bancoContext()
        {
        }

        public bancoContext(DbContextOptions<bancoContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Cliente> Clientes { get; set; } = null!;
        public virtual DbSet<Cuentum> Cuenta { get; set; } = null!;
        public virtual DbSet<Moviento> Movientos { get; set; } = null!;

//        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
//        {
//            if (!optionsBuilder.IsConfigured)
//            {
//#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
//                optionsBuilder.UseSqlServer("Data Source=DESKTOP-3R4Q1SJ\\SQLEXPRESS;Initial Catalog=banco;Integrated Security=True;Pooling=False");
//            }
//        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Cliente>(entity =>
            {
                entity.HasKey(e => e.Idcliente)
                    .IsClustered(false);

                entity.ToTable("CLIENTE");

                entity.HasIndex(e => e.Idcuenta, "RELATIONSHIP_1_FK");

                entity.Property(e => e.Idcliente)
                    .ValueGeneratedNever()
                    .HasColumnName("IDCLIENTE");

                entity.Property(e => e.Direccion)
                    .HasMaxLength(124)
                    .IsUnicode(false)
                    .HasColumnName("DIRECCION");

                entity.Property(e => e.Idcuenta).HasColumnName("IDCUENTA");

                entity.Property(e => e.Nombre)
                    .HasMaxLength(64)
                    .IsUnicode(false)
                    .HasColumnName("NOMBRE");

                entity.HasOne(d => d.IdcuentaNavigation)
                    .WithMany(p => p.Clientes)
                    .HasForeignKey(d => d.Idcuenta)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_CLIENTE_RELATIONS_CUENTA");
            });

            modelBuilder.Entity<Cuentum>(entity =>
            {
                entity.HasKey(e => e.Idcuenta)
                    .IsClustered(false);

                entity.ToTable("CUENTA");

                entity.Property(e => e.Idcuenta)
                    .ValueGeneratedNever()
                    .HasColumnName("IDCUENTA");

                entity.Property(e => e.Numero)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("NUMERO")
                    .IsFixedLength();

                entity.Property(e => e.Saldo)
                    .HasColumnType("decimal(18, 0)")
                    .HasColumnName("SALDO");
            });

            modelBuilder.Entity<Moviento>(entity =>
            {
                entity.HasKey(e => e.Idmovimiento)
                    .IsClustered(false);

                entity.ToTable("MOVIENTO");

                entity.HasIndex(e => e.Idcuenta, "RELATIONSHIP_2_FK");

                entity.Property(e => e.Idmovimiento)
                    .ValueGeneratedNever()
                    .HasColumnName("IDMOVIMIENTO");

                entity.Property(e => e.Fecha)
                    .HasColumnType("datetime")
                    .HasColumnName("FECHA");

                entity.Property(e => e.Idcuenta).HasColumnName("IDCUENTA");

                entity.Property(e => e.Saldofinal)
                    .HasColumnType("decimal(18, 0)")
                    .HasColumnName("SALDOFINAL");

                entity.Property(e => e.Valor)
                    .HasColumnType("decimal(18, 0)")
                    .HasColumnName("VALOR");

                entity.HasOne(d => d.IdcuentaNavigation)
                    .WithMany(p => p.Movientos)
                    .HasForeignKey(d => d.Idcuenta)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_MOVIENTO_RELATIONS_CUENTA");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
