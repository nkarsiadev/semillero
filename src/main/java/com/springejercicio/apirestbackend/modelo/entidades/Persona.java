package com.springejercicio.apirestbackend.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes(
        @JsonSubTypes.Type(value = Usuario.class, name = "usuario")
)
public abstract class Persona implements Serializable { //Abstract nos indica que no se va a instanciar objetos de la clase persona, pero si de sus derivados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 60)
    private String nombre;
    @Column(nullable = false, unique = true, length = 10)
    private String cedula;
    @Column(nullable = false, length = 25)
    private String email;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String cedula, String email) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
