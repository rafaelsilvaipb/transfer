package br.com.cvc.transfer.domain;

import br.com.cvc.transfer.enums.TransferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private BigDecimal feeAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(columnDefinition = "DATE")
    private LocalDate transferAt;

    private String origin;

    private String destination;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransferType type;
}

