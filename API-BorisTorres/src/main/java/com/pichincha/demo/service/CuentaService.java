package com.pichincha.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.demo.exception.Exception.BadRequestException;
import com.pichincha.demo.exception.Exception.NotFoundException;
import com.pichincha.demo.interfaceService.ICuentaService;
import com.pichincha.demo.interfaces.ICuentaP;
import com.pichincha.demo.interfaces.IUsuario;
import com.pichincha.demo.modelo.CuentaP;
import com.pichincha.demo.modelo.Usuario;


@Service
public class CuentaService implements ICuentaService{

	@Autowired
	ICuentaP iCuenta;
	
	@Autowired
	IUsuario iUsuario;
	
	@Override
	public List<CuentaP> listarCuentas() {
		List<CuentaP> cuentas = (List<CuentaP>) iCuenta.findAll();
		if(cuentas.size()>0) {
			return cuentas;
		}else {
			throw new BadRequestException("{\"message\":\"No existen cuentas\",\"status\":false}");
		}
		
	}

	@Override
	public Optional<CuentaP> listarPorCuenta(int ncuenta) {
		if(!iCuenta.existsById(ncuenta))
			throw new NotFoundException("No existe la cuenta con el nuemro: "+ncuenta);
		return iCuenta.findById(ncuenta);
	}

	@Override
	public CuentaP listarPorCedula(int cedulaU) {
		if(!iCuenta.existByCedula(cedulaU)) {
			throw new NotFoundException("No existe la cedula en las cuentas registradas: "+cedulaU);
		}else {
			return iCuenta.findByCedulaU(cedulaU);
		}
		
	}

	@Override
	public CuentaP guardar(CuentaP c, int cedulaU) {
		if(iUsuario.existsById(cedulaU)) {
			Optional<Usuario> usuarios = iUsuario.findById(cedulaU);
			c.setUsuario(usuarios.get());
			if(!iCuenta.existsById(cedulaU)) {
				return iCuenta.save(c);
			}else {
				throw new BadRequestException("Ya esta registrado el numero de cuenta"+c.getNcuenta());
			}
			
		}else {
			throw new NotFoundException("No existe la cedula el usuario: "+cedulaU);
		}
		
	}

	@Override
	public CuentaP actualizarCuenta(int ncuenta, CuentaP c) {
		String mensaje = "";
		Optional<CuentaP> cuentaU = iCuenta.findById(ncuenta);
		if(cuentaU.isPresent()) {
			if( c != null) {
				int cuentaUser = cuentaU.get().getNcuenta();
				int cuentaReg = c.getNcuenta();
				if(cuentaUser == cuentaReg) {
					return iCuenta.save(c);
				}
				mensaje = "No se puede modificar el numero de cuenta";
                throw new BadRequestException(mensaje);
			}else {
				mensaje= "No existe información";
				throw new NotFoundException(mensaje);
			}
		}else {
			mensaje="La informacion no existe";
			throw new NotFoundException(mensaje);
		}
		
	}

	@Override
	public String delete(int ncuenta) {
		if(iCuenta.existsById(ncuenta)) {
			iCuenta.deleteById(ncuenta);
			return "{\"message\":\"Cuenta eliminada con exito, "+ncuenta+"\",\"status\":true}";
		}
		throw new NotFoundException("{\"message\":\"No se elimino, debido a que no se encontro la cuenta "+ncuenta+"\",\"status\":false}");
	}

	
}
