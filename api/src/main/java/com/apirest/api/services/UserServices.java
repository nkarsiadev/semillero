package com.apirest.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.api.models.UserModel;
import com.apirest.api.repositories.*;

@Service // clase de tipo servicio
public class UserServices {
    @Autowired // notacion q no se instancia
    UserRepository UserRepository;// asi llamamos la instancia del repositorio

    public ArrayList<UserModel> obtUsers() {
        return (ArrayList<UserModel>) UserRepository.findAll();
    }

    public UserModel GuardarUser(UserModel Usuarios) {
        return UserRepository.save(Usuarios);
    }

    public Optional<UserModel> BuscarId(Long Id) {
        return UserRepository.findById(Id);
    }

    public ArrayList<UserModel> findByCedula(Integer Cedula) {
        return UserRepository.findByCedula(Cedula);
    }

    public ArrayList<UserModel> findByNombre(String nombre) {
        return UserRepository.findByNombre(nombre);
    }

    public ArrayList<UserModel> findByApellido(String Apellido) {
        return UserRepository.findByApellido(Apellido);
    }

    public ArrayList<UserModel> findByEmail(String Email) {
        return UserRepository.findByEmail(Email);
    }

    public boolean EliminarId(Long Id) {
        try {
            UserRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
