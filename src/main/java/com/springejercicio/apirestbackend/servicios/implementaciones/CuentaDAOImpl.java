package com.springejercicio.apirestbackend.servicios.implementaciones;

import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;
import com.springejercicio.apirestbackend.repositorios.CuentaRepository;
import com.springejercicio.apirestbackend.servicios.contratos.CuentaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class CuentaDAOImpl extends GenericoDAOImpl<Cuenta, CuentaRepository> implements CuentaDAO {

    @Autowired //Inyecte la dependencia - nuestro repositorio genérico será CuentaRepository
    public CuentaDAOImpl(CuentaRepository repository) {
        super(repository);
    }

    /*@Autowired //Inyecte la dependencia de nuestro repositorio
    private CuentaRepository repository;*/

    /*@Override
    //Usamos @Transactional (deriva de spring framework) para trabajar con transacciones contra BD
    @Transactional(readOnly = true)
    public Optional<Cuenta> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Cuenta save(Cuenta cuenta) {
        return repository.save(cuenta);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cuenta> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    } Ya no uso porque son heredados de nuestro DAO Implementación*/
}
