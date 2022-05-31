package br.com.cvc.transfer.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
