package br.com.cvc.transfer.exceptions;

public class InvalidTransferException extends BusinessException{

    public InvalidTransferException(String message){
        super(message);
    }
}
