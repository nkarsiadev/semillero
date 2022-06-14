package com.pichincha.maaseichaq.Entity;

import com.pichincha.maaseichaq.Entity.Usuario;
import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true , nullable = false)
    private Long id_cuenta;

    private String num_cuenta;
    private Double saldo_cuenta;
    private Integer estado_cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public Double getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(Double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public Integer getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(Integer estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public Usuario obtenerUsuario(){
       return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
