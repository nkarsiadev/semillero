package APIRest.api.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import APIRest.api.Exceptions.CuentasNotFoundException;
import APIRest.api.models.Cuenta;

@Repository // conexion a la base de datos
@Transactional // consultas a la base de datos
public class CuentaDaoImp implements CuentaDao {
    

    @PersistenceContext
    EntityManager entityManager; // conecxion con la base de datos

    // get todas las cuenta
    @Override
    public List<Cuenta<Long, String, Float>> getAllCuentas() {
        // System.out.println("buscando cuentas");
        // findAll();
        String query = "FROM Cuenta"; // hay que decirle en que tabla tiene que buscar en clase usuario
        return entityManager.createQuery(query).getResultList();
        // return query;
    }

    // get cuentas de un usuario
    @Override
    public List<Cuenta<Long, String, Float>> getCuentasUsuario(Long usuarioId) {
        // TODO Auto-generated method stub
        String query = "FROM Cuenta WHERE usuarioid="+ usuarioId;
        // System.out.println(entityManager.find(Cuenta.class, usuarioId));

        return entityManager.createQuery(query).getResultList();

    }

    // get una cuenta
    @Override
    public Cuenta<Long, String, Float> getCuenta(Long id) {
        // TODO Auto-generated method stub
        Cuenta<Long, String, Float> cuenta = entityManager.find(Cuenta.class, id);
        return cuenta;
    }

    // crea una cuenta
    @Override
    public Cuenta<Long, String, Float> crearCuenta(Cuenta<Long, String, Float> cuenta) {
        // TODO Auto-generated method stub
        Cuenta nuevoCuenta = entityManager.merge(cuenta);
        return nuevoCuenta;
    }


    // update una cuenta
    @Override
    public Cuenta<Long, String, Float> updateCuenta(Cuenta<Long, String, Float> cuenta) {
        // TODO Auto-generated method stub
        Cuenta nuevoCuenta = entityManager.merge(cuenta);
        return nuevoCuenta;
    }

    // elimina una cuenta
    @Override
    public String eliminarCuenta(Long id) throws CuentasNotFoundException{
        // TODO Auto-generated method stub
        Cuenta<Long, String, Float> cuenta = entityManager.find(Cuenta.class, id);
        if(cuenta == null ){
            throw new CuentasNotFoundException("No se encontro ninguna cuenta con este id: " + id);
        }else {

            entityManager.remove(cuenta);
            // deleteById(id);
            return "cuenta eliminada";
        }
    }

    @Override
    public String eliminarAllCuentas() throws CuentasNotFoundException{
        // TODO Auto-generated method stub
        entityManager.clear();

        String query = "FROM Cuenta"; // hay que decirle en que tabla tiene que buscar en clase usuario
        List<Cuenta<Long, String, Float>> cuentas = entityManager.createQuery(query).getResultList();
        if(cuentas.size() != 0){
            throw new CuentasNotFoundException("No se eliminaron todas las cuentas");
        }else{
            return "No existen cuentas";

        }
        // deleteById(id);
    }
    

}