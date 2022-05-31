package br.com.cvc.transfer.service;

import br.com.cvc.transfer.domain.Transfer;

import java.util.List;

public interface TransferService {
    Transfer save(Transfer transfer);

    List<Transfer> findAll();
}

