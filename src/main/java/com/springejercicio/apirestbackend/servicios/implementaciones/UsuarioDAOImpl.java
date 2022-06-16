package com.springejercicio.apirestbackend.servicios.implementaciones;

import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;
import com.springejercicio.apirestbackend.modelo.entidades.Persona;
import com.springejercicio.apirestbackend.repositorios.PersonaRepository;
import com.springejercicio.apirestbackend.servicios.contratos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements UsuarioDAO {

    @Autowired
    public UsuarioDAOImpl(@Qualifier("respositorioUsuarios")PersonaRepository repository) {
        super(repository);
    }

    /*//Persona repository no es un Bean por lo que le decimos que le denomine a través de
    private PersonaRepository repository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }*/
}
