package com.apirest.api.models;

import javax.persistence.*; /*esta biblioteca ayuda a importr todas las anpotaciones de jpa */

@Entity /* con esto decimos q es un modelo real */
@Table(name = "Usuarios") /* para llamar al nombre de la tabla */
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*
                                                         * es un id q se genera automaticamente es unico y no pued *
                                                         * nulo
                                                         */
    private Long Id;
    private Integer Cedula;
    private String Nombre;
    private String Email;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer cedulas) {
        Cedula = cedulas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
