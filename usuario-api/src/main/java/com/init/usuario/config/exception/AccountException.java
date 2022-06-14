package com.init.usuario.config.exception;

public class AccountException extends RuntimeException{
    
    public AccountException(String message) {
        super(message);
    }

    public AccountException() {}
}
