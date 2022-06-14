package APIRest.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import APIRest.api.Exceptions.UsuariosNotDeletedException;
import APIRest.api.Exceptions.UsuariosNotFoundException;
import APIRest.api.models.Usuario;

public interface UsuarioDao { // Data Access Object

    List<Usuario<Long, String>> getUsuarios();
    public Usuario<Long, String> getUsuario(Long id);

    String eliminarUsuario(Long id) throws UsuariosNotFoundException ;
    
    String eliminarAllUsuarios()throws UsuariosNotDeletedException ;

    Usuario<Long, String> crearUsuario(Usuario<Long, String> usuario);
    
    Usuario<Long, String> updateUsuario(Usuario<Long, String> usuario);

}