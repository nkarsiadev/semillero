package com.springejercicio.apirestbackend.controlador;

import com.springejercicio.apirestbackend.exception.BadRequestException;
import com.springejercicio.apirestbackend.modelo.entidades.Cuenta;
import com.springejercicio.apirestbackend.modelo.entidades.Persona;
import com.springejercicio.apirestbackend.servicios.contratos.CuentaDAO;
import com.springejercicio.apirestbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final PersonaDAO usuarioDAO;
    private final CuentaDAO cuentaDAO;

    @Autowired
    public UsuarioController(@Qualifier("usuarioDAOImpl") PersonaDAO usuarioDAO, CuentaDAO cuentaDAO) {
        this.usuarioDAO = usuarioDAO;
        this.cuentaDAO = cuentaDAO;
    }

    @GetMapping
    public List<Persona> obtenerTodas(){
        List<Persona> usuarios = (List<Persona>) usuarioDAO.findAll();
        if(usuarios.isEmpty()){
            throw new BadRequestException("No existen usuarios");
        }
        return usuarios;
    }
    @GetMapping("/{id}")
    public Persona obtenerUsuarioPorId(@PathVariable Integer id){
        Optional<Persona> oUsuario = usuarioDAO.findById(id);
        if(!oUsuario.isPresent()){
            throw new BadRequestException(String.format("Usuario con id %id no existe", id));
        }
        return oUsuario.get();
    }
    @PostMapping
    public Persona agregarUsuario(@RequestBody Persona usuario){
        return usuarioDAO.save(usuario);
    }

    @PutMapping("/{id}")
    public Persona actualizarUsuario(@PathVariable Integer id, @RequestBody Persona usuario){
        Persona usuarioUpdate = null;
        Optional<Persona> oUsuario = usuarioDAO.findById(id);
        if(!oUsuario.isPresent()){
            throw new BadRequestException(String.format("Usuario con id %d no existe", id));
        }
        usuarioUpdate = oUsuario.get();
        usuarioUpdate.setNombre(usuario.getNombre());
        usuarioUpdate.setEmail(usuario.getEmail());
        usuarioUpdate.setCedula(usuario.getCedula());
        return usuarioDAO.save(usuarioUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioDAO.deleteById(id);
    }

    @PutMapping("/{idUsuario}/cuenta/{idCuenta}")
    public Persona asignarCuentasUsuario(@PathVariable Integer idUsuario, @PathVariable Integer idCuenta) {
        Optional<Persona> oUsuario = usuarioDAO.findById(idUsuario);
        if (!oUsuario.isPresent()) {
            throw new BadRequestException(String.format("Usuario con id %id no existe", idUsuario));
        }
        Optional<Cuenta> oCuenta = cuentaDAO.findById(idCuenta);
        if (!oCuenta.isPresent()) {
            throw new BadRequestException(String.format("Usuario con id %id no existe", idCuenta));
        }
        Persona usuario = oUsuario.get();
        Cuenta cuenta = oCuenta.get();

        return usuarioDAO.save(usuario);
    }
}
