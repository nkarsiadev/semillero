package pichincha.com.backtarea.Repository;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pichincha.com.backtarea.Entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    // encuentra un usuario por su id y lo retorna, este codigo evita insertar
    // consultas Query de SQL
    Optional<Cuenta> findByIdCuenta(Long idCuenta);

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    ArrayList<Cuenta> findByUsuarioIdUsuario(Long idUsuario);

    @Transactional
    void deleteByIdCuenta(Long idCuenta);
}
