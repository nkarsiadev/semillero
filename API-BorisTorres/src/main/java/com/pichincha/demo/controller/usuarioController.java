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

import com.pichincha.demo.modelo.Usuario;
import com.pichincha.demo.service.UsuarioService;

@Controller
@RequestMapping("/api/user")
public class usuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listar());
	}
	
	@GetMapping("/list/{cedula}")
	public ResponseEntity<Optional<Usuario>> listarUsuarioCedula(@PathVariable("cedula") int ceduda){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarPorCedula(ceduda));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario u){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(u));
	}
	
	@PutMapping("/update/{cedula}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("cedula") int cedula, @RequestBody Usuario u){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.actualizarUsuario(cedula, u));
	}
	
	@DeleteMapping("/delete/{cedula}")
	public ResponseEntity<?> eliminar(@PathVariable("cedula") int cedula){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.delete(cedula));
	}
	

	
	
	
	
	/*
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/listar")
	public String lsitar(Model model) {
		List<Usuario>usuarios = service.listar();
		model.addAttribute("usuarios", usuarios);
		return "index";
	}
	
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "form";
	}
	
	
	//public String save(@Valid Usuario u, Model model) {
	@PostMapping("/save")
	public String save(Usuario u, Model model) {
		service.save(u);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/editar/{cedula}")
	public String editar(@PathVariable int cedula, Model model) {
		Optional<Usuario>usuario = service.listarCedula(cedula);
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@GetMapping("/eliminar/{cedula}")
	public String delete(Model model, @PathVariable int cedula) {
		service.delete(cedula);
		return "redirect:/listar";
	}
	*/

}
