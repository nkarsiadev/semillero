package com.pichincha.maaseichaq.Service;

import com.pichincha.maaseichaq.Entity.Usuario;
import com.pichincha.maaseichaq.ExceptionsProyect.Exception.BadRequestException;
import com.pichincha.maaseichaq.ExceptionsProyect.Exception.NotFoundException;
import com.pichincha.maaseichaq.Repository.UsuarioRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServicio {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> users = (List<Usuario>) usuarioRepository.findAll();
        if (users.size() > 0){
            return users;
        }else{
            throw new BadRequestException("{\"message\":\"No existen usuarios\",\"status\":false}");
        }
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario){
        String mensaje;
        String cedula = usuario.getCedula();
        String email = usuario.getEmail();
        if (validarCedula(cedula)) {
            Usuario userEmail = usuarioRepository.findByEmail(email);
            Usuario userCedula = usuarioRepository.findByCedula(cedula);
            if (userCedula == null && userEmail == null) {
                return usuarioRepository.save(usuario);
            }
            if (userCedula != null) {
                mensaje = "Ya existe un usuario con la cédula " + cedula;
                throw new BadRequestException(mensaje);
            }
            if (userEmail != null) {
                mensaje = "Ya existe un usuario con el email " + email;
                throw new BadRequestException(mensaje);
            }
            mensaje = "Usuario no registrado contactese con el admin";
            throw new BadRequestException(mensaje);
        }else {
            mensaje = "La cédula "+cedula+" es incorrecta";
            throw new BadRequestException(mensaje);
        }
    }
    @Override
    public Optional<Usuario> obtenerPorId(Long id){
        if (!usuarioRepository.existsById(id))
            throw new NotFoundException("No existe el usuario con el id "+id);
        return usuarioRepository.findById(id);
    }
    @Override
    public Usuario obtenerPorCedula(String cedula){
        if (!usuarioRepository.existByCedula(cedula))
            throw new NotFoundException("No existe el usuario con la cedula "+cedula);
        return usuarioRepository.findByCedula(cedula);
    }
    @Override
    public Usuario obtenerPorEmail(String email){
        if (!usuarioRepository.existByEmail(email))
            throw new NotFoundException("No existe el usuario con el email "+email);
        return usuarioRepository.findByEmail(email);
    }
    @Override
    public String eliminarUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return "{\"message\":\"Usuario eliminado exitosamente con el id "+id+"\",\"status\":true}";
        }else{
            throw new NotFoundException("{\"message\":\"No existe el usuario con el id "+id+"\",\"status\":false}");
        }
    }
    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario){
        String mensaje = "";
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (user.isPresent()){
            if (usuario != null){
                String cedUser = user.get().getCedula();
                String cedUsuario = usuario.getCedula();
                if (validarCedula(cedUsuario)){
                    if (cedUser.equals(cedUsuario)) {
                        usuario.setId(id);
                        return usuarioRepository.save(usuario);
                    }else{
                        mensaje = "No se puede modificar la cedula";
                        throw new BadRequestException(mensaje);
                    }
                }else{
                    mensaje = "La cédula es incorrecta";
                    throw new BadRequestException(mensaje);
                }
            }else{
                mensaje = "Error de datos";
                throw new BadRequestException(mensaje);
            }
        }else{
            mensaje = "No se encontró al usuario con el id ("+id+")";
            throw new NotFoundException(mensaje);
        }
    }
    private Boolean validarCedula(String cedula){
        boolean cedulaCorrecta;
        if (cedula.length() == 10) // ConstantesApp.LongitudCedula
        {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
            // Coeficientes de validación cédula
            // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                int verificador = Integer.parseInt(cedula.substring(9,10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                }
                else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } else {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }
}
