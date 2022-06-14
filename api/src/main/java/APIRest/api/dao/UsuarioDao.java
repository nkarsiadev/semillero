package APIRest.api.dao;

import java.util.List;

import APIRest.api.models.Usuario;

public interface UsuarioDao { // Data Access Object

    List<Usuario<Long, String>> getUsuarios();

    String eliminarUsuario(Long id);

    public Usuario<Long, String> getUsuario(Long id);

    Usuario<Long, String> crearUsuario(Usuario<Long, String> usuario);

}