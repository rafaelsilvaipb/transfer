package br.com.cvc.transfer.dto;

import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferDTO {

    @NotNull
    private BigDecimal amount;

    @FutureOrPresent
    private LocalDate transferAt;

    @NotBlank
    private String accountOrigin;

    @NotBlank
    private String account;
}
