package br.com.cvc.transfer.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferDTOTest {

    @Test
    public void testTransferDTO(){
        TransferDTO transferDTO = TransferDTO.builder()
                .transferAt(LocalDate.now())
                .account("123456")
                .accountOrigin("123456")
                .amount(BigDecimal.ONE)
                .build();

        TransferDTO transferDTO2 = new TransferDTO();
        transferDTO2.setTransferAt(LocalDate.now());
        transferDTO2.setAccount("123456");
        transferDTO2.setAccountOrigin("123456");
        transferDTO2.setAmount(BigDecimal.ONE);

        Assertions.assertEquals(transferDTO.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transferDTO.getAccount(), "123456");
        Assertions.assertEquals(transferDTO.getAccountOrigin(), "123456");
        Assertions.assertEquals(transferDTO.getAmount(), BigDecimal.ONE);

        Assertions.assertEquals(transferDTO2.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transferDTO2.getAccount(), "123456");
        Assertions.assertEquals(transferDTO2.getAccountOrigin(), "123456");
        Assertions.assertEquals(transferDTO2.getAmount(), BigDecimal.ONE);



    }
}
