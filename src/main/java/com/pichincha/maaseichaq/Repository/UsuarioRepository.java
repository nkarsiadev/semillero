package com.pichincha.maaseichaq.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pichincha.maaseichaq.Entity.Usuario;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuario, Long> {
    public Usuario findByCedula(String cedula);
    @Query(value = "SELECT COUNT(u.id) = 1 FROM usuario u WHERE u.cedula LIKE %:cedula%", nativeQuery = true)
    public Boolean existByCedula(@Param("cedula") String cedula);
    @Query(value = "SELECT COUNT(u.id) = 1 FROM usuario u WHERE u.email LIKE %:email%", nativeQuery = true)
    public Boolean existByEmail(@Param("email") String email);
    public Usuario findByEmail(String email);
}
