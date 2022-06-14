package com.pichincha.demo.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pichincha.demo.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByCedula(int cedula);
	
	@Query (value = "SELECT * FORM usuario u WHERE u.nombre LIKE %:nombre", nativeQuery = true)
	public Boolean existByNombre(@Param("nombre")String nombre);
	@Query (value = "SELECT COUNT(u.n_cedula)=1 FORM usuario u WHERE u.n_cuenta LIKE %:n_cuenta", nativeQuery = true)
	public Boolean existByCuenta(@Param("n_cuenta") int n_cuenta);

}
