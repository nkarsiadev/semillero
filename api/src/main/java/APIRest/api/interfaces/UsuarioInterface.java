package APIRest.api.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import APIRest.api.models.Usuario;

@RestController
public interface UsuarioInterface {

    Usuario getUsuario(Long id);

    List<Usuario> getUsuarios();

    Usuario crearUsuario();

    Usuario actualizarUsuario();

    String eliminarUsuario();

    String eliminarUsuarios();

}