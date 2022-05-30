package br.com.cvc.transfer.dto;

import br.com.cvc.transfer.enums.TransferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransferResponseDTO {
    private Long id;
    private BigDecimal amount;
    private BigDecimal feeAmount;
    private TransferType type;
    private LocalDate createdAt;
    private LocalDate transferAt;
    private String accountOrigin;
    private String accountDestination;
}