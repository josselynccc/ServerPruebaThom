package com.api.bankTransfer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bankTransfer.entity.Transfer;
import com.api.bankTransfer.repository.TransferRepository;

@Service
public class TransferServiceImpl implements ITransferService{
    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return transferRepository.findById(id);
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public void deleteById(Long id) {
        transferRepository.deleteById(id);
    }

    @Override
    public Transfer updateById(Long id, Transfer transfer) {
        return transferRepository.findById(id)
            .map(existingTransfer -> {
                existingTransfer.setName(transfer.getName());
                existingTransfer.setAccountNumber(transfer.getAccountNumber());
                existingTransfer.setAmount(transfer.getAmount());
                existingTransfer.setDescription(transfer.getDescription());
                existingTransfer.setEmail(transfer.getEmail());
                return transferRepository.save(existingTransfer);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Transfer no encontrada con id: " + id));
    }

}