package APIRest.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIRest.api.Exceptions.CuentasNotFoundException;
import APIRest.api.dao.CuentaDao;
import APIRest.api.models.Cuenta;

// copy repo to this reop haciendo un fork
// hacer el pull request
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
    @RequestMapping(value = "cuentas/update/{id}", method = RequestMethod.PUT)
    public Cuenta<Long, String, Float> actualizarCuenta(@RequestBody Cuenta cuenta) {
        // Cuenta<Long, String, Float> cuenta = new Cuenta();
        return cuentaDao.updateCuenta(cuenta);
    }

    
    // elimina todas las cuentas de un usuario
    // @RequestMapping(value = "cuentas/eliminar/{usuarioId}", method = RequestMethod.DELETE)
    // public Cuenta<Long, String, Float> eliminarCuentasUsuario(@PathVariable Long usuarioId) {
    //     Cuenta<Long, String, Float> cuenta = new Cuenta();
    //     return cuenta;
    // }

    // elimina un cuenta
    @RequestMapping(value = "cuentas/eliminar/{usuarioId}/{id}", method = RequestMethod.DELETE)
    public String eliminarCuenta(@PathVariable Long usuarioId, @PathVariable Long id) {
        try {
            return cuentaDao.eliminarCuenta(id);            
        } catch (CuentasNotFoundException e) {
            return "Error: " + e.getMessage();
        }
    }

    // elimina todas las cuenta
    @RequestMapping(value = "cuentas/eliminar", method = RequestMethod.DELETE)
    public String eliminarAllCuentas() {
        try {
            return cuentaDao.eliminarAllCuentas();            
        } catch (Exception e) {
            //TODO: handle exception
            return "Error: "+ e.getMessage();
        }
    }


}