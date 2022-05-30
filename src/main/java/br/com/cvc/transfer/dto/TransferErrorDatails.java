package br.com.cvc.transfer.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferErrorDatails {
    private String title;
    private int status;
}
