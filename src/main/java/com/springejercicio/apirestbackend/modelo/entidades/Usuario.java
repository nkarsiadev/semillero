package com.springejercicio.apirestbackend.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona {
    @Column(name = "nombre_usuario", unique = true, nullable = false)
    private String nombreUsuario;

    /*@OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY   //Hacer una carga perezosa para no tener mucha carga en la BD
    )*/
    //private Set<Cuenta> cuentas; //Coleccion cuentas
    public Usuario() {
    }
    //Este constructor hace un llamado a la clase Padre (Persona), pero setea tambien el atributo de Usuario (nombreUsuario)
    public Usuario(Integer id, String nombre, String cedula, String email, String nombreUsuario) {
        super(id, nombre, cedula, email);
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /*public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }*/

    @Override
    public String toString() {
        return super.toString() +
                "\tUsuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
