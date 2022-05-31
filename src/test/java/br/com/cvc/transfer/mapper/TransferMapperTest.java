package br.com.cvc.transfer.mapper;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.dto.TransferDTO;
import br.com.cvc.transfer.dto.TransferResponseDTO;
import br.com.cvc.transfer.enums.TransferType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferMapperTest {

    @Test
    public void testTransferMapperTest(){
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

        TransferResponseDTO transferResponseDTO = TransferMapper.modelToResponse(transfer);


        transferResponseDTO.setTransferAt(LocalDate.now());

        Assertions.assertEquals(transferResponseDTO.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO.getCreatedAt(), LocalDate.now());
        Assertions.assertEquals(transferResponseDTO.getId(), 2L);
        Assertions.assertEquals(transferResponseDTO.getType(), TransferType.SAME_DAY);
        Assertions.assertEquals(transferResponseDTO.getAccountOrigin(), "123456");
        Assertions.assertEquals(transferResponseDTO.getAccountDestination(), "123456");
        Assertions.assertEquals(transferResponseDTO.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals(transferResponseDTO.getFeeAmount(), BigDecimal.TEN);
    }

    @Test
    public void testDTOToModel(){
        TransferDTO transferDTO = TransferDTO.builder()
                .transferAt(LocalDate.now())
                .account("123456")
                .accountOrigin("123456")
                .amount(BigDecimal.ONE)
                .build();

        Transfer transfer = TransferMapper.DTOToModel(transferDTO);

        Assertions.assertEquals(transfer.getTransferAt(), LocalDate.now());
        Assertions.assertEquals(transfer.getOrigin(),"123456" );
        Assertions.assertEquals(transfer.getDestination(), "123456");
        Assertions.assertEquals(transfer.getAmount(), BigDecimal.ONE);





    }
}
