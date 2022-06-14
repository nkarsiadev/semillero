package com.example.demo.interfaces;

import com.example.demo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioService extends JpaRepository<Usuario, Long> {

}
