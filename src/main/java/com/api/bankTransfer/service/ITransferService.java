package com.api.bankTransfer.service;
import java.util.List;
import java.util.Optional;


import com.api.bankTransfer.entity.Transfer;

public interface ITransferService {
    List<Transfer> findAll();
    Optional<Transfer> findById(Long Id);
    Transfer save(Transfer transfer);
    void deleteById(Long id);
    Transfer updateById(Long id, Transfer transfer);
}
