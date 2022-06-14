package pichincha.com.backtarea.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pichincha.com.backtarea.Entity.Cliente;
import pichincha.com.backtarea.Entity.Cuenta;
import pichincha.com.backtarea.Entity.Usuario;
import pichincha.com.backtarea.Exception.UsuarioServiceException;
import pichincha.com.backtarea.Exception.UsuarioServiceNullException;
import pichincha.com.backtarea.Repository.CuentaRepository;
import pichincha.com.backtarea.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        try {
            return listaUsuarios;
        } catch (UsuarioServiceNullException e) {
            // e.printStackTrace();
            throw new UsuarioServiceNullException("No se pudo obtener la lista de usuarios");
        }

    }

    public void eliminarUsuarioPorId(Long idUsuario) throws UsuarioServiceException {
        try {
            usuarioRepository.deleteById(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioServiceException("Error al eliminar el usuario por id:" + idUsuario + "!");
        }
    }

    public Usuario createUsuario(Usuario usuario) throws UsuarioServiceException {
        Optional<Usuario> usuarioRepetido = usuarioRepository.findByCiUsuario(usuario.getCiUsuario());
        try {
            if (usuarioRepetido.isPresent()) {
                throw new UsuarioServiceException("El usuario con CI: " + usuario.getCiUsuario() + " e ID: "
                        + usuario.getIdUsuario() + "ya existe!");
            }
            usuario.setEdadUsuario();
            Usuario usuarioCreated = usuarioRepository.save(usuario);
            return usuarioCreated;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioServiceException(
                    "Error al crear el usuario con CI: " + usuario.getCiUsuario() + " por CI repetido!");
        }
    }

    public Usuario updateUsuario(Long idUsuario, Usuario usuario) throws UsuarioServiceException {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(idUsuario);
        try {

            // Si el usuario existe utilizando isPresent() actualizo sus datos en la BD
            if (usuarioEncontrado.isPresent()) {
                usuario.setIdUsuario(idUsuario);// seteo el id del usuario a la entidad que llega, asi no crea una nueva
                usuario.setEdadUsuario();

                // guarda los datos actualizados en la BD utilizando JPA
                Usuario usuarioUpdated = usuarioRepository.save(usuario);
                return usuarioUpdated;
            } else {
                throw new UsuarioServiceException("El usuario con CI: " + usuario.getCiUsuario() + " no existe!");
            }
        } catch (UsuarioServiceNullException e) {
            e.printStackTrace();
            throw new UsuarioServiceNullException(
                    "No se pudo encontrara de usuarios" + usuario.getCiUsuario() + " para modificar!");
        }
    }

    public Cliente<Cuenta> getUsuarioById(Long idUsuario) throws UsuarioServiceException {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(idUsuario);
        Cliente<Cuenta> obj = new Cliente<Cuenta>();
        ArrayList<Cuenta> listaCuentas = cuentaRepository.findByUsuarioIdUsuario(idUsuario);
        try {
            if (usuarioEncontrado.isPresent()) {

                obj.setEntities1(listaCuentas);
                obj.setEntities2(usuarioEncontrado.get());
                return obj;
            } else {
                throw new UsuarioServiceException("No se encontro el usuario con el id: " + idUsuario);
            }
        } catch (UsuarioServiceNullException e) {
            e.printStackTrace();
            throw new UsuarioServiceNullException("Problemas a buscar el usuario id:" + idUsuario);
        }
    }

}
