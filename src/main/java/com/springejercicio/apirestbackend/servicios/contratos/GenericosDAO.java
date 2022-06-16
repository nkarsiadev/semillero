package com.springejercicio.apirestbackend.servicios.contratos;

import com.springejercicio.apirestbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface GenericosDAO<E> {
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
