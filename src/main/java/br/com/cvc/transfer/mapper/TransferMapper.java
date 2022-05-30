package br.com.cvc.transfer.mapper;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.dto.TransferDTO;
import br.com.cvc.transfer.dto.TransferResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TransferMapper {

        public static Transfer DTOToModel(TransferDTO transferDTO){
            return Transfer.builder()
                    .transferAt(transferDTO.getTransferAt())
                    .createdAt(LocalDate.now())
                    .amount(transferDTO.getAmount())
                    .destination(transferDTO.getAccount())
                    .origin(transferDTO.getAccountOrigin())
                    .build();
        }


        public static TransferResponseDTO modelToResponse(Transfer transfer){
            return new TransferResponseDTO(
                    transfer.getId(),
                    transfer.getAmount(),
                    transfer.getFeeAmount(),
                    transfer.getType(),
                    transfer.getCreatedAt(),
                    transfer.getTransferAt(),
                    transfer.getOrigin(),
                    transfer.getDestination()
            );
        }
    }
