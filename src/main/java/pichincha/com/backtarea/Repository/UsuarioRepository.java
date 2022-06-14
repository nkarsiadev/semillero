package pichincha.com.backtarea.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pichincha.com.backtarea.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // encuentra un usuario por su id y lo retorna, este codigo evita insertar
    // consultas Query de SQL
    Optional<Usuario> findByIdUsuario(Long idUsuario);

    Optional<Usuario> findByCiUsuario(String ciUsuario);

    // Busca el usuario y lo elimina segun el codigo, da el provilegio a hibernate
    // de eliminar en la BD
    @Transactional
    void deleteByIdUsuario(Long idUsuario);
}
