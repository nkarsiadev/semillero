package com.pichincha.maaseichaq.ExceptionsProyect.Exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){
    }
    public BadRequestException(String message){
        super(message);
    }
}
