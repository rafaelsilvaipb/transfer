package br.com.cvc.transfer.domain;

import br.com.cvc.transfer.enums.TransferType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferTest {

    @Test
    public void testTransferDomain(){
        Transfer transfer = Transfer.builder()
                .id(2L)
                .transferAt(LocalDate.now())
                .amount(BigDecimal.ONE)
                .createdAt(LocalDate.now())
                .destination("123456")
                .feeAmount(BigDecimal.TEN)
                .origin("123456")
                .type(TransferType.SAME_DAY)
                .build();

        Transfer transfer2 = new Transfer();
        transfer2.setTransferAt(LocalDate.now());
        transfer2.setType(TransferType.REGRESSIVE_DATE);
        transfer2.setDestination("123456");
        transfer2.setAmount(BigDecimal.ONE);
        transfer2.setCreatedAt(LocalDate.now());
        transfer2.setId(2L);
        transfer2.setFeeAmount(BigDecimal.TEN);
        transfer2.setOrigin("123456");



        Assertions.assertEquals(transfer.getId(), 2L);
        Assertions.assertEquals(transfer.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transfer.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals(transfer.getCreatedAt(), LocalDate.now());
        Assertions.assertEquals(transfer.getType(), TransferType.SAME_DAY);
        Assertions.assertEquals(transfer.getDestination(), "123456");
        Assertions.assertEquals(transfer.getFeeAmount(), BigDecimal.TEN);
        Assertions.assertEquals(transfer.getOrigin(), "123456");

        Assertions.assertEquals(transfer2.getId(), 2L);
        Assertions.assertEquals(transfer2.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transfer2.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals(transfer2.getCreatedAt(), LocalDate.now());
        Assertions.assertEquals(transfer2.getType(), TransferType.REGRESSIVE_DATE);
        Assertions.assertEquals(transfer2.getDestination(), "123456");
        Assertions.assertEquals(transfer2.getFeeAmount(), BigDecimal.TEN);
        Assertions.assertEquals(transfer2.getOrigin(), "123456");

    }
}
