package br.com.cvc.transfer.rules;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.enums.TransferType;
import br.com.cvc.transfer.exceptions.DateIntervalInvalidException;
import br.com.cvc.transfer.exceptions.InvalidTransferException;
import br.com.cvc.transfer.exceptions.UndefinedFeeException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class TransferRule {
    public static TransferType defineTransferType(LocalDate transferDate){
        if(transferDate.isBefore(LocalDate.now())){
            throw new DateIntervalInvalidException("Invalid Date");
        }
        if(transferDate.isEqual(LocalDate.now())){
            return TransferType.SAME_DAY;
        }
        if(Duration.between(LocalDate.now().atStartOfDay(), transferDate.atStartOfDay()).toDays() <= 10){
            return TransferType.UNTIL_TEN_DAYS;
        }
        if(Duration.between(LocalDate.now().atStartOfDay(), transferDate.atStartOfDay()).toDays() > 10){
            return TransferType.REGRESSIVE_DATE;
        }
        throw new DateIntervalInvalidException("Invalid Date interval");
    }

    public static BigDecimal calculateFee(Transfer transfer){
        long scheduleAndTransferDaysDifference = Duration.between(transfer.getCreatedAt().atStartOfDay(), transfer.getTransferAt().atStartOfDay()).toDays();

        if (Objects.nonNull(transfer.getType())) {
            switch (transfer.getType()) {
                case SAME_DAY:
                    return BigDecimal.valueOf(3L).add(transfer.getAmount().multiply(BigDecimal.valueOf(0.03)));
                case UNTIL_TEN_DAYS:
                    if(scheduleAndTransferDaysDifference == 0){
                        return BigDecimal.valueOf(12L);
                    }
                    return BigDecimal.valueOf(12L).multiply(BigDecimal.valueOf(scheduleAndTransferDaysDifference));
                case REGRESSIVE_DATE:
                    if (scheduleAndTransferDaysDifference > 10 && scheduleAndTransferDaysDifference <= 20) {
                        return transfer.getAmount().multiply(BigDecimal.valueOf(0.08));
                    }
                    if (scheduleAndTransferDaysDifference > 20 && scheduleAndTransferDaysDifference <= 30) {
                        return transfer.getAmount().multiply(BigDecimal.valueOf(0.06));
                    }
                    if (scheduleAndTransferDaysDifference > 30 && scheduleAndTransferDaysDifference <= 40) {
                        return transfer.getAmount().multiply(BigDecimal.valueOf(0.04));
                    }
                    if (scheduleAndTransferDaysDifference > 40 && transfer.getAmount().longValue() > 100000) {
                        return transfer.getAmount().multiply(BigDecimal.valueOf(0.02));
                    }
            }
        }
        throw new UndefinedFeeException("Undefined fee");
    }

    public static void checkIfOriginDifferentFromDestination(Transfer transfer){
        if(transfer.getOrigin().equals(transfer.getDestination())) {
            throw new InvalidTransferException("Account origin and destination cannot be the same");
        }
    }
}
