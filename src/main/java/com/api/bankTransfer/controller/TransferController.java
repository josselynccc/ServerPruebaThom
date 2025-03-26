package com.api.bankTransfer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.bankTransfer.entity.Transfer;
import com.api.bankTransfer.service.ITransferService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/transfers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TransferController {
    @Autowired
    private ITransferService transferService;

    @GetMapping("/all")
    public ResponseEntity<List<Transfer>> findAll() {
        return ResponseEntity.ok(transferService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transfer> findById(@PathVariable Long id) {
        Optional<Transfer> transfer = transferService.findById(id);
        return transfer.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Transfer> save(@RequestBody Transfer transfer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transferService.save(transfer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        transferService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Transfer> updateTransfer(
            @PathVariable Long id,
            @RequestBody Transfer transferDetails) {
        return ResponseEntity.ok(transferService.updateById(id, transferDetails));
    }
    
}
