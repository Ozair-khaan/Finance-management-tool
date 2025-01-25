package com.finance.service;

import com.finance.entities.Transaction;
import com.finance.entities.User;
import com.finance.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionByUser(User user){
        return  transactionRepository.findByUser(user);
    }

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
