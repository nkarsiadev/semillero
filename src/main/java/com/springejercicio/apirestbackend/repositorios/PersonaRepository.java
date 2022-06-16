package com.springejercicio.apirestbackend.repositorios;

import com.springejercicio.apirestbackend.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //Que no me genere un bean de Persona, pero si un bean de las clases hijas
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
