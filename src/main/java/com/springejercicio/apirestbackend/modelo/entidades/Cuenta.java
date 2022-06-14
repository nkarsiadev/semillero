package com.springejercicio.apirestbackend.modelo.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que va a ser autoincrementable
    @Column(unique = true, nullable = false) //ID único y no nulo
    private Integer id;

    @Column(name="numero_cuenta", nullable = false)
    private String numeroCuenta;
    @Column(name="saldo_cuenta", nullable = false)
    private double saldo;

    //Muchas cuentas van a pertenecer a un usuario
    /*@ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "usuario_id",
            foreignKey = @ForeignKey(name = "FK_USUARIO_ID")
    )*/
    //private Usuario usuario;

    public Cuenta() {
    }

    public Cuenta(Integer id, String numeroCuenta, double saldo) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
