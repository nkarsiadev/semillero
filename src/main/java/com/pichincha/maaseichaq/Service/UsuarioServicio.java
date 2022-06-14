package com.pichincha.maaseichaq.Service;

import java.util.List;
import java.util.Optional;

import com.pichincha.maaseichaq.Entity.Usuario;
import netscape.javascript.JSObject;

public interface UsuarioServicio {
    public List<Usuario> obtenerUsuarios();
    public Usuario guardarUsuario(Usuario usuario);
    public Optional<Usuario> obtenerPorId(Long id);
    public Usuario obtenerPorCedula(String cedula);
    public Usuario obtenerPorEmail(String email);
    public String eliminarUsuario(Long id);
    public Usuario actualizarUsuario(Long id, Usuario usuario);
}
