package br.com.cvc.transfer.controller;

import br.com.cvc.transfer.dto.TransferDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransferControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAndGetTransfer() throws Exception {
        TransferDTO transferDTO = TransferDTO.builder()
                .transferAt(LocalDate.now())
                .account("123456")
                .accountOrigin("1234567")
                .amount(BigDecimal.ONE)
                .build();

        mvc.perform(post("/transfer").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transferDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").exists());

        mvc.perform(get("/transfer"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0]").exists())
                .andExpect(jsonPath("$.[0].id").isNotEmpty());

    }

}
