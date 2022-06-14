package com.init.usuario.service;

import com.init.usuario.config.exception.UserException;
import com.init.usuario.dao.AccountsDAO;
import com.init.usuario.entitys.Account;

import java.util.List;
import java.util.Optional;

import com.init.usuario.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
public class AccountService {

    @Autowired
    private AccountsDAO AccountsDAO;

    public List<Account> getAccount(){
        return AccountsDAO.findAll();
    }

    public Account getAccountById(Long accountId){
        if (!AccountsDAO.existsById(accountId)){
            throw new UserException("El id no existe");
        }
        return AccountsDAO.findById(accountId).get();
    }

    public Account createAccount(Account account, Long userId){
        if (account.getNumber() == null || account.getNumber().isEmpty()){
            throw new UserException("Invalid Number");
        }
        return AccountsDAO.save(account);
    }

    public Void deleteAccount(Long accountId){
        if (!AccountsDAO.existsById(accountId)){
            throw new UserException("El id no existe");
        }
        AccountsDAO.deleteById(accountId);
        return null;
    }

    public Account updateAccount(Account account){
        if (!AccountsDAO.existsById(account.getId())){
            throw new UserException("El id no existe");
        }
        Optional<Account> optionalAccount = AccountsDAO.findById(account.getId());
        Account updateAccount = optionalAccount.get();
        updateAccount.setNumber(account.getNumber());
        updateAccount.setType(account.getType());
        return AccountsDAO.save(updateAccount);
    }
}
