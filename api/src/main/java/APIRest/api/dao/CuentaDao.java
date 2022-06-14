package APIRest.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import APIRest.api.Exceptions.CuentasNotDeletedException;
import APIRest.api.Exceptions.CuentasNotFoundException;
import APIRest.api.models.Cuenta;

public interface CuentaDao { // DAO: Data Access Object

    public List<Cuenta<Long, String, Float>> getAllCuentas();

    public List<Cuenta<Long, String, Float>> getCuentasUsuario(Long usuarioId);

    public Cuenta<Long, String, Float> getCuenta(Long id);

    public String eliminarCuenta(Long id) throws CuentasNotFoundException;

    public String eliminarAllCuentas() throws CuentasNotFoundException;

    public Cuenta<Long, String, Float> crearCuenta(Cuenta<Long, String, Float> cuenta);

    public Cuenta<Long, String, Float> updateCuenta(Cuenta<Long, String, Float> cuenta);


}