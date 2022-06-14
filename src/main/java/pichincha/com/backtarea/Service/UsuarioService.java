package pichincha.com.backtarea.Service;

import java.util.List;

import pichincha.com.backtarea.Entity.Cliente;
import pichincha.com.backtarea.Entity.Cuenta;
import pichincha.com.backtarea.Entity.Usuario;
import pichincha.com.backtarea.Exception.UsuarioServiceException;

public interface UsuarioService {

    List<Usuario> getAll();

    void eliminarUsuarioPorId(Long idUsuario) throws UsuarioServiceException;

    Usuario createUsuario(Usuario usuario) throws UsuarioServiceException;

    Usuario updateUsuario(Long idUsuario, Usuario usuario) throws UsuarioServiceException;

    Cliente<Cuenta> getUsuarioById(Long idUsuario) throws UsuarioServiceException;

}
