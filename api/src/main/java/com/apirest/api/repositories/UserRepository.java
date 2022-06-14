package com.apirest.api.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirest.api.models.UserModel;

@Repository // agregamos la notacion q va hacer de tipo repositori

public interface UserRepository extends CrudRepository<UserModel, Long> { // va hacer una interfaz porq va a utilizar
                                                                          // ciertos me todos como crud ya esta
                                                                          // programado

     public abstract ArrayList<UserModel> findByCedula(Integer Cedula);

     public abstract ArrayList<UserModel> findByNombre(String Nombre);

     public abstract ArrayList<UserModel> findByApellido(String Apellido);

     public abstract ArrayList<UserModel> findByEmail(String Email);

}
