package br.com.cvc.transfer.dto;

import br.com.cvc.transfer.enums.TransferType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferResponseDTOTest {

    @Test
    public void testTransferResponse() {
        TransferResponseDTO transferResponseDTO = new TransferResponseDTO();
        transferResponseDTO.setTransferAt(LocalDate.now());
        transferResponseDTO.setAccountDestination("123456");
        transferResponseDTO.setAccountOrigin("123456");
        transferResponseDTO.setCreatedAt(LocalDate.now());
        transferResponseDTO.setAmount(BigDecimal.ONE);
        transferResponseDTO.setFeeAmount(BigDecimal.TEN);
        transferResponseDTO.setType(TransferType.SAME_DAY);
        transferResponseDTO.setId(2L);

        TransferResponseDTO transferResponseDTO2 = TransferResponseDTO.builder()
                .transferAt(LocalDate.now())
                .accountDestination("123456")
                .accountOrigin("123456")
                .createdAt(LocalDate.now())
                .amount(BigDecimal.ONE)
                .feeAmount(BigDecimal.TEN)
                .id(2L)
                .type(TransferType.SAME_DAY).build();

        Assertions.assertEquals(transferResponseDTO.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals(transferResponseDTO.getFeeAmount(), BigDecimal.TEN);
        Assertions.assertEquals(transferResponseDTO.getType(), TransferType.SAME_DAY);
        Assertions.assertEquals(transferResponseDTO.getAccountDestination(), "123456");
        Assertions.assertEquals(transferResponseDTO.getAccountOrigin(), "123456");
        Assertions.assertEquals(transferResponseDTO.getCreatedAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO.getId(), 2L);

        Assertions.assertEquals(transferResponseDTO2.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO2.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals(transferResponseDTO2.getFeeAmount(), BigDecimal.TEN);
        Assertions.assertEquals(transferResponseDTO2.getType(), TransferType.SAME_DAY);
        Assertions.assertEquals(transferResponseDTO2.getAccountDestination(), "123456");
        Assertions.assertEquals(transferResponseDTO2.getAccountOrigin(), "123456");
        Assertions.assertEquals(transferResponseDTO2.getCreatedAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO2.getId(), 2L);
    }

//        TransferErrorDatails transferErrorDatails2 = TransferErrorDatails.builder().status(404).title("Invalid Date interval").build();
//
//
//        Assertions.assertEquals(transferErrorDatails.getStatus(), 404);
//        Assertions.assertEquals(transferErrorDatails.getTitle(), "Invalid Date interval");
//
//        Assertions.assertEquals(transferErrorDatails2.getStatus(), 404);
//        Assertions.assertEquals(transferErrorDatails2.getTitle(), "Invalid Date interval");


    }
