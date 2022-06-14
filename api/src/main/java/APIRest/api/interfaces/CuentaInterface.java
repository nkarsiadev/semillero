package APIRest.api.interfaces;

import java.util.List;

import APIRest.api.models.Cuenta;

public interface CuentaInterface {

    public List<Cuenta> getCuentas();

    public Cuenta getCuentasUsuario(Long usuarioId);

    public Cuenta getCuenta(Long usuarioId, Long id);

    public Cuenta crearCuenta();

    public Cuenta actualizarCuenta(Long id);

    public Cuenta eliminarCuentas();

    public Cuenta eliminarCuentasUsuario(Long usuarioId);

    public Cuenta eliminarCuenta(Long usuarioId, Long id);

}