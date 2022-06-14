package com.pichincha.demo.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pichincha.demo.modelo.CuentaP;

@Repository
public interface ICuentaP extends CrudRepository<CuentaP, Integer> {
	
	public CuentaP findByNcuenta(int nceunta);
	
	@Query (value="SELECT COUNT(*) FROM `cuenta` WHERE cedula=%:cedulaU", nativeQuery=true)
	public Boolean existByCedula(@Param("cedulaU")int cedulaU);
	
	public CuentaP findByCedulaU(int cedulaU);
	
	
}
