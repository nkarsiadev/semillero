/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entidades.Cuenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gaby
 */
@Repository
public interface CuentaService extends JpaRepository<Cuenta, Long>{
	@Query(value = "SELECT * FROM cuenta WHERE id_usuario=?1",nativeQuery=true)
    List<Cuenta> findByIdUsuario(Long id_usuario);
}