package com.pichincha.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pichincha.demo.exception.Exception.BadRequestException;
import com.pichincha.demo.exception.Exception.NotFoundException;
import com.pichincha.demo.interfaceService.IUsuarioService;
import com.pichincha.demo.interfaces.IUsuario;
import com.pichincha.demo.modelo.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuario iUsuario;
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = (List<Usuario>) iUsuario.findAll();
		if(usuarios.size() >0) {
			return usuarios;
		}else {
			throw new BadRequestException("{\"message\":\"No existen usuarios\",\"status\":false}");
		}
		
	}

	@Override
	public Optional<Usuario> listarPorCedula(int cedula) {
		if(!iUsuario.existsById(cedula))
			throw new NotFoundException("No existe el usuario con la cedula "+cedula);
		return iUsuario.findById(cedula);
	}

	
	@Override
	public Usuario listarPorCuenta(int n_cuenta) {
		if(!iUsuario.existByCuenta(n_cuenta))
			throw new NotFoundException("No existe la cuenta registrada: " +n_cuenta);
		return iUsuario.findByCedula(n_cuenta);
	}

	
	@Override
	public Usuario guardar(Usuario u) {
		String mensaje;
		int cedula = u.getCedula();
		if(validacionCedula(cedula)) {
			Usuario usuarioCedula = iUsuario.findByCedula(cedula);
			
			if(usuarioCedula == null) {
				return iUsuario.save(u);
			}
			
			if(usuarioCedula != null) {
				mensaje = "Ya esta el usuario registrado";
				throw new BadRequestException(mensaje);
			}
			
			mensaje = "Usuario tuvo problemas al registro, preguntar al admin";
			throw new BadRequestException(mensaje);
			
	}else {
		mensaje ="La cedula de ciudadania no es valida";
		throw new BadRequestException(mensaje);
	}
	}
	

	@Override
	public String delete(int cedula) {
		if(iUsuario.existsById(cedula)) {
			iUsuario.deleteById(cedula);
			return "{\"message\":\"Usuario eliminado con exito, "+cedula+"\",\"status\":true}";
			
		}else {
			throw new NotFoundException("{\"message\":\"No se elimino, debido a que no se encontro usuarios con la cedula"+cedula+"\",\"status\":false}");
		}
	}

	@Override
	public Usuario actualizarUsuario(int cedula, Usuario u) {
		String mensaje = "";
		Optional<Usuario> usuarioU = iUsuario.findById(cedula);
		if(usuarioU.isPresent()) {
			if(u != null) {
				int cedUser = usuarioU.get().getCedula();
				int CedulaReg = u.getCedula();
				if(cedUser == CedulaReg) {
					return iUsuario.save(u);
				}
				mensaje = "No se puede modificar la cedula";
                throw new BadRequestException(mensaje);		
			}else {
				 mensaje = "Error de datos";
	             throw new BadRequestException(mensaje);
			}
		}else {
			mensaje = "La información no existe";
            throw new NotFoundException(mensaje);
		}
		
	}
	
	//metodos de validacion
	
	private Boolean validacionCedula(int cedula){
		
		String ci = String.valueOf(cedula);
		
		 boolean cedulaCorrecta;
	        if (ci.length() == 10)
	        {
	            int tercerDigito = Integer.parseInt(ci.substring(2, 3));
	            if (tercerDigito < 6) {
	                int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
	                int verificador = Integer.parseInt(ci.substring(9,10));
	                int suma = 0;
	                int digito = 0;
	                for (int i = 0; i < (ci.length() - 1); i++) {
	                    digito = Integer.parseInt(ci.substring(i, i + 1))* coefValCedula[i];
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

	

