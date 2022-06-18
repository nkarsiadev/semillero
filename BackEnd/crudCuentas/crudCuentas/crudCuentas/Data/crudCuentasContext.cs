using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using crudCuentas.Models;

namespace crudCuentas.Data
{
    public class crudCuentasContext : DbContext
    {
        public crudCuentasContext (DbContextOptions<crudCuentasContext> options)
            : base(options)
        {
        }

        public DbSet<crudCuentas.Models.cuentas>? cuentas { get; set; }

        public DbSet<crudCuentas.Models.usuarios>? usuarios { get; set; }
    }
}
