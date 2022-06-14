package com.init.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.usuario.entitys.User;

public interface UsersDAO extends JpaRepository<User, Long>{

}
