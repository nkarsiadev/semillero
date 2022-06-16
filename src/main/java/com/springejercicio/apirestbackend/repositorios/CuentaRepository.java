package com.springejercicio.apirestbackend.repositorios;

import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Integer> { //Poner el tipo de entidad con la que vamos a trabajar y tipo de dato de nuestra PK

}
