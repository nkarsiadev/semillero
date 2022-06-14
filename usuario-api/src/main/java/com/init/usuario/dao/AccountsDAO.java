package com.init.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.usuario.entitys.Account;

public interface AccountsDAO extends JpaRepository<Account, Long>{
    
}
