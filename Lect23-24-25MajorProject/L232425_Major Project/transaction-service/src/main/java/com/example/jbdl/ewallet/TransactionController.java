package com.example.jbdl.ewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transact")
    public String createTxn(@Valid @RequestBody TransactionCreateRequest transactionCreateRequest){
        String txnId = transactionService.createTxn(transactionCreateRequest.to());
        return "Your transaction has been initiated, here's the transaction id : " + txnId;
    }
}
