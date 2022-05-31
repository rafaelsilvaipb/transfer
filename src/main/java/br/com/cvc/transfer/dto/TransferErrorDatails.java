package br.com.cvc.transfer.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferErrorDatails {
    String title;
    int status;
}
