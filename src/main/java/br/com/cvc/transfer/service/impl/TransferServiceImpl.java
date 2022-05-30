package br.com.cvc.transfer.service.impl;

import br.com.cvc.transfer.domain.Transfer;
import br.com.cvc.transfer.repository.TransferRepository;
import br.com.cvc.transfer.rules.TransferRule;
import br.com.cvc.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferRepository transferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        transfer.setType(TransferRule.defineTransferType(transfer.getTransferAt()));
        transfer.setFeeAmount(TransferRule.calculateFee(transfer));
        return this.transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }


}

