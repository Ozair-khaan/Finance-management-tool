package com.finance.controller;

import com.finance.entities.Transaction;
import com.finance.entities.User;
import com.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/add")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok("Transaction saved successfully");
    }

    public List<Transaction> getTransaction(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return transactionService.getTransactionByUser(user);
    }
}
