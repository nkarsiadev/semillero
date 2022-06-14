package com.springejercicio.apirestbackend.repositorios;

import org.springframework.stereotype.Repository;

@Repository("respositorioUsuarios")  //El bean se llamará UsuarioRepository
public interface UsuarioRepository extends PersonaRepository {
}
