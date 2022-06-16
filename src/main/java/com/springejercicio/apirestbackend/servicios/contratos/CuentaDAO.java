package com.springejercicio.apirestbackend.servicios.contratos;

import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;

import java.util.Optional;

public interface CuentaDAO extends GenericosDAO<Cuenta> {

    /*Optional: Permite encapsular el error de Null Pointer Exception y nos permite saber si hay o no presencia de datos
    Optional<Cuenta> findById(Integer id);
    Cuenta save(Cuenta cuenta);
    //Retorna la interfaz iterable de colección y retorna todas la cuentas
    Iterable<Cuenta> findAll();
    //Recibe el id, elimina la cuenta con ese id
    void deleteById(Integer id);*/
}
