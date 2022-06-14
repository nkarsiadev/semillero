package com.pichincha.maaseichaq.Controller;

import com.pichincha.maaseichaq.Entity.*;
import com.pichincha.maaseichaq.Service.CuentaService;
import com.pichincha.maaseichaq.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cuenta>> listCuentas(){
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.obtenerCuentas());
    }
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Optional<Cuenta>> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.obtenerPorId(id));
    }
    @GetMapping("/numero_cuenta")
    public ResponseEntity<Cuenta> buscarPorNumCuenta(@RequestParam("num_cuenta") String num_cuenta){
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.obtenerPorNumCuenta(num_cuenta));
    }
    @PostMapping("/save/{id}")
    public ResponseEntity<Cuenta> guardarCuenta(@RequestBody Cuenta cuenta,@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.guardarCuenta(cuenta,id));
    }
    @DeleteMapping(path = "/del/{id}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.eliminarCuenta(id));
    }
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta,@RequestParam("id_user") Long id_user){
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.actualizarCuenta(id,cuenta,id_user));
    }

}
