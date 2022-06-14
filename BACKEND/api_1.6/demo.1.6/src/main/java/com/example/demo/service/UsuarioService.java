/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gaby
 */
@Service
public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario> list() {
        return usuarios;
    }

    //get usuario
    public Usuario find(Long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    //create usuario
    public Usuario crear(Usuario user) {
        usuarios.add(user);
        return user;
    }

    //update
    public Usuario update(Long id, Usuario user) {
        int index = 0;
        for (Usuario l : usuarios) {
            if (l.getId() == id) {
                user.setId(id);
                usuarios.set(index, user);
            }
        }
        return user;
    }

    //delete
    public boolean delete(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return usuarios.remove(u);
            }
        }
        return false;
    }
}
