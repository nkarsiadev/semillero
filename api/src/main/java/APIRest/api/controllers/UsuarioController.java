package APIRest.api.controllers;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIRest.api.dao.UsuarioDao;
import APIRest.api.models.Usuario;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    // get un usuario
    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.GET)
    public Usuario<Long, String> getUsuario(@PathVariable Long id) {
        // try {
        return usuarioDao.getUsuario(id);

        // } catch (Exception e) {
        // //TODO: handle exception
        // System.out.println("Usuario no encontrado");
        // }
    }

    // Get todos los usuarios
    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public List<Usuario<Long, String>> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    // crea un usuario
    @RequestMapping(value = "usuarios/registrar", method = RequestMethod.POST)
    public Usuario<Long, String> crearUsuario(@RequestBody Usuario<Long, String> usuario) {
        return usuarioDao.crearUsuario(usuario);
    }

    // Actualiza un usuario
    @RequestMapping(value = "usuarios/actualizar/{id}", method = RequestMethod.PUT)
    public Usuario<Long, String> actualizarUsuario() {
        Usuario<Long, String> usuario = new Usuario<>();
        return usuario;
    }

    // elimina un usuario
    @RequestMapping(value = "usuarios/eliminar/{id}", method = RequestMethod.DELETE)
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioDao.eliminarUsuario(id);
        return "usuario eliminado";
    }

    // elimina todos los usuarios
    @RequestMapping(value = "usuarios/eliminar", method = RequestMethod.DELETE)
    public String eliminarUsuarios() {
        Usuario<Long, String> usuario = new Usuario<>();
        return "no existen usuarios";
    }

}