package com.api.bankTransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bankTransfer.entity.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long>{
    
}
