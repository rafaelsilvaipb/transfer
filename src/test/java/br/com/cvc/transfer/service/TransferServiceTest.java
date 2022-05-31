package br.com.cvc.transfer.service;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.repository.TransferRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class TransferServiceTest {

    @Autowired
    private TransferRepository TransferRepository;

    @Autowired
    private TransferService transferService;

    @Test
    public void testTransferService(){

        Transfer transfer = Transfer.builder()
                .transferAt(LocalDate.now())
                .createdAt(LocalDate.now())
                .amount(BigDecimal.ONE)
                .destination("123456")
                .origin("123455")
                .build();


        Transfer save = transferService.save(transfer);
        Assertions.assertEquals(save.getId(), 1L);

        List<Transfer> all = transferService.findAll();
        Assertions.assertEquals(all.get(0).getId(), 1L);

    }

}
