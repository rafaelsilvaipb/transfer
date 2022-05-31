package br.com.cvc.transfer.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransferErrorDatailsTest {

    @Test
    public void testDatailsTest(){
        TransferErrorDatails transferErrorDatails = new TransferErrorDatails();
        transferErrorDatails.setStatus(404);
        transferErrorDatails.setTitle("Invalid Date interval");

        TransferErrorDatails transferErrorDatails2 = TransferErrorDatails.builder().status(404).title("Invalid Date interval").build();


        Assertions.assertEquals(transferErrorDatails.getStatus(), 404);
        Assertions.assertEquals(transferErrorDatails.getTitle(), "Invalid Date interval");

        Assertions.assertEquals(transferErrorDatails2.getStatus(), 404);
        Assertions.assertEquals(transferErrorDatails2.getTitle(), "Invalid Date interval");


    }



}
