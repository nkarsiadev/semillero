package com.pichincha.maaseichaq.Repository;

import com.pichincha.maaseichaq.Entity.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
    @Query(value = "SELECT * FROM cuenta c WHERE c.num_cuenta LIKE %:num_cuenta%", nativeQuery = true)
    public Cuenta searchNumCuenta(@Param("num_cuenta") String num_cuenta);

    @Query(value = "SELECT COUNT(c.id_cuenta) = 1 FROM cuenta c WHERE c.num_cuenta LIKE %:num_cuenta%", nativeQuery = true)
    public Boolean existByNumCuenta(@Param("num_cuenta") String num_cuenta);
}
