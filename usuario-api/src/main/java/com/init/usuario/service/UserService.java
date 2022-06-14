package com.init.usuario.service;

import com.init.usuario.config.exception.UserException;
import com.init.usuario.entitys.User;
import com.init.usuario.dao.UsersDAO;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UsersDAO UsersDAO;

    public List<User> getUsers(){
        return UsersDAO.findAll();
    }

    public User getUSerById(Long userId){
        if (!UsersDAO.existsById(userId)){
            throw new UserException("El id no existe");
        }
        return UsersDAO.findById(userId).get();
    }

    public User createUser(User user){
        if (user.getName() == null || user.getName().isEmpty()){
            throw new UserException("Invalid Name");
        }
        return UsersDAO.save(user);
    }

    public Void deleteUser(Long userId){
        if (!UsersDAO.existsById(userId)){
            throw new UserException("El id no existe");
        }
        UsersDAO.deleteById(userId);
        return null;
    }

    public User updateUser(User user){
        if (!UsersDAO.existsById(user.getId())){
            throw new UserException("El id no existe");
        }
        Optional<User> optionalUser = UsersDAO.findById(user.getId());
        User updateUser = optionalUser.get();
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setIdentification(user.getIdentification());
        updateUser.setPassword(user.getPassword());
        return UsersDAO.save(updateUser);
    }
}
