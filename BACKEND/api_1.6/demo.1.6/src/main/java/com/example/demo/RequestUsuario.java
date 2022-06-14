package com.example.demo;

import com.example.demo.entidades.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicesREST")
public class RequestUsuario {

    private final UsuarioService service;

    public RequestUsuario(UsuarioService service) {
        this.service = service;

    }
    @GetMapping
    public Iterable<Usuario> list(){
        return service.list();
    }
    @GetMapping("/{id}")
    public Usuario find (@PathVariable("id")Long id){
        return service.find(id);
    }
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return service.crear(usuario);
    }
    @PutMapping
    public Usuario update(@PathVariable("id")Long id,@RequestBody Usuario usuario){
        return service.update(id, usuario);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return service.delete(id);
    }
    

}
