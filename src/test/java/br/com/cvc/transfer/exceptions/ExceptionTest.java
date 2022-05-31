package br.com.cvc.transfer.exceptions;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.enums.TransferType;
import br.com.cvc.transfer.rules.TransferRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class ExceptionTest {

    @Test
    public void defineTaxDateIntervalInvalidException() {
        Assertions.assertThrows(DateIntervalInvalidException.class, () -> TransferRule.defineTransferType(LocalDate.now().plusDays(-1)));
    }

    @Test
    public void defineUndefinedFeeException() {
        LocalDate today = LocalDate.now();
        Transfer transfer = new Transfer(new Random().nextLong(), BigDecimal.valueOf(100000),null,today,today.plusDays(41),"42342442", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        Assertions.assertThrows(UndefinedFeeException.class, () -> TransferRule.calculateFee(transfer));

    }

    @Test
    public void defineInvalidTransferException() {
        LocalDate today = LocalDate.now();
        Transfer transfer = new
                Transfer(new Random().nextLong(), BigDecimal.valueOf(100000),null,today,today.plusDays(41),"423424421212", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        Assertions.assertThrows(InvalidTransferException.class, () ->
                TransferRule.checkIfOriginDifferentFromDestination(transfer));
    }
}
