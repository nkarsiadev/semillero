package APIRest.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIRest.api.dao.CuentaDao;
import APIRest.api.interfaces.CuentaInterface;
import APIRest.api.models.Cuenta;

@RestController
public class CuentaController {

    @Autowired
    private CuentaDao cuentaDao;

    // get todas las cuentas

    @RequestMapping(value = "cuentas", method = RequestMethod.GET)
    public List<Cuenta<Long, String, Float>> getAllCuentas() {
        System.out.println("buscando cuentas");
        return cuentaDao.getAllCuentas();
    }

    // get todas las cuentas de un usuario
    @RequestMapping(value = "cuentas/{usuarioId}")
    public List<Cuenta<Long, String, Float>> getCuentasUsuario(@PathVariable Long usuarioId) {
        System.out.println("buscando cuentas");
        return cuentaDao.getCuentasUsuario(usuarioId);

        // Cuenta cuenta = new Cuenta();

        // List<Cuenta> cuentas = new ArrayList<>();
        // Cuenta cuenta1 = new Cuenta();
        // cuenta1.setId(1L);
        // cuenta1.setUsuarioId(1712345678L);
        // cuenta1.setTipoCuenta("Ahorros");
        // cuenta1.setNumeroCuenta(123456);
        // cuenta1.setSaldo(1000F);
        // // cuenta1.setDepositos(100F);
        // // cuenta1.setRetiros(50F);

        // Cuenta cuenta2 = new Cuenta();
        // cuenta2.setId(1L);
        // cuenta2.setUsuarioId(1612345678L);
        // cuenta2.setTipoCuenta("Ahorros");
        // cuenta2.setNumeroCuenta(223456);
        // cuenta2.setSaldo(2000F);
        // // cuenta2.setDepositos(300F);
        // // cuenta2.setRetiros(505F);

        // Cuenta cuenta3 = new Cuenta();

        // cuenta3.setId(1L);
        // cuenta3.setUsuarioId(1512345678L);
        // cuenta3.setTipoCuenta("Ahorros");
        // cuenta3.setNumeroCuenta(323456);
        // cuenta3.setSaldo(10000F);
        // // cuenta3.setDepositos(1000F);
        // // cuenta3.setRetiros(700F);

        // cuentas.add(cuenta1);
        // cuentas.add(cuenta2);
        // cuentas.add(cuenta3);

        // // return cuentas;
    }

    // get una cuenta de un usuario
    @RequestMapping(value = "cuentas/{usuarioId}/{id}")
    public Cuenta<Long, String, Float> getCuenta(@PathVariable Long usuarioId, @PathVariable Long id) {

        return cuentaDao.getCuenta(id);
    }

    // crea un cuenta
    @RequestMapping(value = "cuentas/crear", method = RequestMethod.POST)
    public Cuenta<Long, String, Float> crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaDao.crearCuenta(cuenta);
    }

    // Actualiza un cuenta
    @RequestMapping(value = "cuentas/actualizar/{id}", method = RequestMethod.PUT)
    public Cuenta<Long, String, Float> actualizarCuenta(@PathVariable Long id) {
        Cuenta<Long, String, Float> cuenta = new Cuenta();
        return cuenta;
    }

    // elimina todos los cuentas
    @RequestMapping(value = "cuentas/eliminar", method = RequestMethod.DELETE)
    public Cuenta<Long, String, Float> eliminarCuentas() {
        Cuenta<Long, String, Float> cuenta = new Cuenta();
        return cuenta;
    }

    // elimina todas las cuentas de un usuario
    @RequestMapping(value = "cuentas/eliminar/{usuarioId}", method = RequestMethod.DELETE)
    public Cuenta<Long, String, Float> eliminarCuentasUsuario(@PathVariable Long usuarioId) {
        Cuenta<Long, String, Float> cuenta = new Cuenta();
        return cuenta;
    }

    // elimina un cuenta
    @RequestMapping(value = "cuentas/eliminar/{usuarioId}/{id}", method = RequestMethod.DELETE)
    public String eliminarCuenta(@PathVariable Long usuarioId, @PathVariable Long id) {
        return cuentaDao.eliminarCuenta(id);
    }

}