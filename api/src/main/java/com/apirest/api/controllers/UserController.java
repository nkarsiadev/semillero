package com.apirest.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.api.models.UserModel;
import com.apirest.api.services.*;;

@RestController // etiqueta q va a decir spring q es su funcion
@RequestMapping("/Usuarios") // en q dirrecion del servidor se va activar los metodos de esta clase
public class UserController {
    @Autowired // sirve para instanciar directamente por spring a otras clases
    UserServices userServices;

    @GetMapping() // indica q cuando llega una peticion de tipo get desde el navegador ejecute
                  // este flujo
    public ArrayList<UserModel> obtUsers() {
        return userServices.obtUsers();
    }

    @PostMapping // regresar el usuario con el id
    public UserModel GuardarUser(@RequestBody UserModel Usuarios) {// el request body es es el envío de un mensaje de //
                                                                   // una aplicación cliente a otra aplicación servidora
        return this.userServices.GuardarUser(Usuarios);
    }

    @GetMapping(path = "/{Id}")
    public Optional<UserModel> BuscarId(@PathVariable("Id") Long Id) {
        return this.userServices.BuscarId(Id);
    }

    @GetMapping(path = "/Cedula={Cedula}")
    public ArrayList<UserModel> findByCedula(@PathVariable("Cedula") Integer Cedula) {
        return this.userServices.findByCedula(Cedula);
    }

    @GetMapping(path = "/Nombre={Nombre}")
    public ArrayList<UserModel> findByNombre(@PathVariable("Nombre") String Nombre) {
        return this.userServices.findByNombre(Nombre);
    }

    @GetMapping(path = "/Apellido={Apellido}")
    public ArrayList<UserModel> findByApellido(@PathVariable("Apellido") String Apellido) {
        return this.userServices.findByApellido(Apellido);
    }

    @GetMapping(path = "/Email={Email}")
    public ArrayList<UserModel> findByEmail(@PathVariable("Edad") String Email) {
        return this.userServices.findByEmail(Email);
    }

    @DeleteMapping(path = "/{Id}")
    public String EliminarId(@PathVariable("Id") Long Id) {
        boolean aux = this.userServices.EliminarId(Id);
        if (aux == true) {
            return "Se eliminó el usuario: " + Id;

        } else {
            return "No se eliminó el usuario: " + Id;
        }

    }

}
