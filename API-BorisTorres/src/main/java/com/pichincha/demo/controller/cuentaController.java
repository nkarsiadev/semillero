package com.pichincha.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pichincha.demo.modelo.CuentaP;
import com.pichincha.demo.service.CuentaService;

@Controller
@RequestMapping("/api/account")
public class cuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping("/list")
	public ResponseEntity<List<CuentaP>> listarCuentas(){
		return ResponseEntity.status(HttpStatus.OK).body(cuentaService.listarCuentas());
	}
	
	@GetMapping("/list/{ncuenta}")
	public ResponseEntity<Optional<CuentaP>> listarConNumeroCuenta(@PathVariable("ncuenta")int ncuenta){
		return ResponseEntity.status(HttpStatus.OK).body(cuentaService.listarPorCuenta(ncuenta));
	}
	
	@PostMapping("/create/{cedulaU}")
	public ResponseEntity<CuentaP> guardar(@RequestBody CuentaP c, @PathVariable(value="cedulaU") int cedulaU){
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.guardar(c, cedulaU));
	}
	
	@PutMapping("/update/{ncuenta}")
	public ResponseEntity<CuentaP> actualizarUsuario(@PathVariable("ncuenta") int ncuenta, @RequestBody CuentaP c){
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.actualizarCuenta(ncuenta, c));
	}
	
	@DeleteMapping("/delete/{ncuenta}")
	public ResponseEntity<?> eliminar(@PathVariable("ncuenta") int ncuenta){
		return ResponseEntity.status(HttpStatus.OK).body(cuentaService.delete(ncuenta));
	}
	
	

	
	
	
}
