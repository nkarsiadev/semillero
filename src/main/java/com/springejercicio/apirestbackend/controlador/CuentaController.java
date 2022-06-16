package com.springejercicio.apirestbackend.controlador;

import com.springejercicio.apirestbackend.exception.BadRequestException;
import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;
import com.springejercicio.apirestbackend.servicios.contratos.CuentaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    private final CuentaDAO cuentaDAO;

    @Autowired
    public CuentaController(CuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    @GetMapping //Controlar con try y catch
    public List<Cuenta> obtenerTodas(){
        List<Cuenta> cuentas = (List<Cuenta>) cuentaDAO.findAll();
        if(cuentas.isEmpty()){
            throw new BadRequestException("No existe la cuenta");
        }
        return cuentas;
    }

    @GetMapping("/{id}")
    public Cuenta obtenerPorId(@PathVariable Integer id){
        Optional<Cuenta> oCuenta = cuentaDAO.findById(id);
        if(!oCuenta.isPresent()){
            throw new BadRequestException(String.format("La cuenta con id %d no existe", id));
        }
        return oCuenta.get();
    }

    @PostMapping
    public Cuenta agregarCuenta(@RequestBody Cuenta cuenta){
        if(cuenta.getSaldo() < 0){
            throw new BadRequestException("El saldo no pueder ser negativo");
        }
        return  cuentaDAO.save(cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta actualizarCuenta(@PathVariable Integer id, @RequestBody Cuenta cuenta){
        Cuenta cuentaUpdate = null;
        Optional<Cuenta> oCuenta = cuentaDAO.findById(id);
        if(!oCuenta.isPresent()){
            throw new BadRequestException(String.format("La cuenta con id %d no existe", id));
        }
        cuentaUpdate = oCuenta.get();
        cuentaUpdate.setSaldo(cuenta.getSaldo());
        return cuentaDAO.save(cuentaUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable Integer id){
        cuentaDAO.deleteById(id);
    }
}
