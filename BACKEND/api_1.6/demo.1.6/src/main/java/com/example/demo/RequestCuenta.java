/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import com.example.demo.entidades.Cuenta;
import com.example.demo.service.CuentaService;
import com.example.demo.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Gaby
 */
public class RequestCuenta {
      @Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private UsuarioService userService;
	
	@GetMapping ("listar")
	public List<Cuenta> getCuentas(){
		return this.cuentaService.findAll();
	}
	
	@PostMapping("{id}/save")
	public Cuenta crearCuenta(@PathVariable(value = "id")Long id_usuario, @RequestBody Cuenta cuenta) throws ResourceNotFoundException{
		return userService.findById(id_usuario).map(user->{
			cuenta.setUser(user);
			return cuentaService.save(cuenta);
		}).orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario con el ID: "+id_usuario));
	}
}
