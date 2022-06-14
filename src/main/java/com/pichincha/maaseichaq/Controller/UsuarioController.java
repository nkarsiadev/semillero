package com.pichincha.maaseichaq.Controller;

import com.pichincha.maaseichaq.Service.UsuarioService;
import net.minidev.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pichincha.maaseichaq.Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obtenerUsuarios());
    }

    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obtenerPorId(id));
    }
    @GetMapping("/cedula")
    public ResponseEntity<Usuario> obtenerUsuarioPorCedula(@RequestParam("cedula") String cedula){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obtenerPorCedula(cedula));
    }
    @DeleteMapping(path = "/del/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.eliminarUsuario(id));
    }
    @PutMapping(path = "/update/{id}")
    public  ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.actualizarUsuario(id,usuario));
    }
    @PostMapping("/save")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuario));
    }
}
