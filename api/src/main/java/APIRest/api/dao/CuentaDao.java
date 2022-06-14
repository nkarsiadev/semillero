package APIRest.api.dao;

import java.util.List;

import APIRest.api.models.Cuenta;

public interface CuentaDao { // DAO: Data Access Object

    public List<Cuenta<Long, String, Float>> getAllCuentas();

    public List<Cuenta<Long, String, Float>> getCuentasUsuario(Long usuarioId);

    public Cuenta<Long, String, Float> getCuenta(Long id);

    public String eliminarCuenta(Long id);

    public Cuenta<Long, String, Float> crearCuenta(Cuenta<Long, String, Float> cuenta);

}