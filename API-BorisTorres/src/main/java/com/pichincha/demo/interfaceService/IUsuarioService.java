 package com.pichincha.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.pichincha.demo.modelo.Usuario;

public interface IUsuarioService {
	public List<Usuario>listar();
	public Optional<Usuario>listarPorCedula(int cedula);
	public Usuario listarPorCuenta(int  n_cuenta);
	public Usuario guardar(Usuario u);
	public String delete(int cedula);
	public Usuario actualizarUsuario(int cedula, Usuario u);
}
