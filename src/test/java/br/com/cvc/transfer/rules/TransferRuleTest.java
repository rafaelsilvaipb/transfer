package br.com.cvc.transfer.rules;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.enums.TransferType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class TransferRuleTest {

    @Test
    public void defineTransferTypeSameDay(){

        TransferType transferType = TransferRule.defineTransferType(LocalDate.now());
        Assertions.assertEquals(TransferType.SAME_DAY.name(), transferType.name());

    }

    @Test
    public void defineTransferTypeUntilTenDays(){

        TransferType transferType = TransferRule.defineTransferType(LocalDate.now().plusDays(10));
        Assertions.assertEquals(TransferType.UNTIL_TEN_DAYS.name(), transferType.name());
    }

    @Test
    public void defineTransferTypeRegressiveDate(){

        TransferType transferType = TransferRule.defineTransferType(LocalDate.now().plusDays(11));
        Assertions.assertEquals(TransferType.REGRESSIVE_DATE.name(), transferType.name());

    }

    @Test
    public void defineFeeTransferTypeSameDay(){

        Transfer transfer =  new Transfer(new Random().nextLong(), BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now().plusDays(2), "42342442", "423424421212",null);
        transfer.setType(TransferType.SAME_DAY);
        BigDecimal bigDecimal = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(3.30).setScale(2), bigDecimal);
    }

    @Test
    public void defineFeeTransferTypeUNTIL_TEN_DAYS(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now().plusDays(9),"42342442", "423424421212",null);
        transfer.setType(TransferType.UNTIL_TEN_DAYS);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(108),taxAmount);;
    }

    @Test
    public void defineFeeTransferTypeUNTIL_TEN_DAYS2(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now(),"42342442", "423424421212",null);
        transfer.setType(TransferType.UNTIL_TEN_DAYS);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(12),taxAmount);
    }

    @Test
    public void defineFeeTransferTypeREGRESSIVE_DATE(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now().plusDays(15),"42342442", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(0.80).setScale(2),taxAmount);
    }

    @Test
    public void defineFeeTransferTypeREGRESSIVE_DATE2(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now().plusDays(25),"42342442", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(0.60).setScale(2),taxAmount);
    }

    @Test
    public void defineFeeTransferTypeREGRESSIVE_DATE3(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(10),null,LocalDate.now(),
                LocalDate.now().plusDays(35),"42342442", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(0.40).setScale(2),taxAmount);
    }

    @Test
    public void defineFeeTransferTypeREGRESSIVE_DATE4(){

        Transfer transfer =  new Transfer(new Random().nextLong(),BigDecimal.valueOf(100001),null,LocalDate.now(),
                LocalDate.now().plusDays(41),"42342442", "423424421212",null);
        transfer.setType(TransferType.REGRESSIVE_DATE);
        BigDecimal taxAmount = TransferRule.calculateFee(transfer);

        Assertions.assertEquals(BigDecimal.valueOf(2000.02).setScale(2),taxAmount);
    }







}
