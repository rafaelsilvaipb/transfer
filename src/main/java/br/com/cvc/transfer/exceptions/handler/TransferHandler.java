package br.com.cvc.transfer.exceptions.handler;

import br.com.cvc.transfer.dto.TransferErrorDatails;
import br.com.cvc.transfer.exceptions.DateIntervalInvalidException;
import br.com.cvc.transfer.exceptions.InvalidTransferException;
import br.com.cvc.transfer.exceptions.UndefinedFeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransferHandler {

    @ExceptionHandler(UndefinedFeeException.class)
    public ResponseEntity<?> handlerFee(UndefinedFeeException fee) {

        TransferErrorDatails details = TransferErrorDatails.builder().title(fee.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<?> invalidTransfer(UndefinedFeeException fee) {

        TransferErrorDatails details = TransferErrorDatails.builder().title(fee.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateIntervalInvalidException.class)
    public ResponseEntity<?> dateIntervalInvalid(UndefinedFeeException fee) {

        TransferErrorDatails details = TransferErrorDatails.builder().title(fee.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

}