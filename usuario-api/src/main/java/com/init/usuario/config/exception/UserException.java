package com.init.usuario.config.exception;

public class UserException extends RuntimeException{
    public UserException(String message) {
        super(message);
    }

    public UserException() {
    }
}
