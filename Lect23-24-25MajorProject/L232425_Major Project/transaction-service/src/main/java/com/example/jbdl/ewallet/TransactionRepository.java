package com.example.jbdl.ewallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

//    @Query("update Transaction t set t.transactionStatus = ?2 where t.txnId = ?1")
//    void updateTxn(String txnId, TransactionStatus transactionStatus);

    Transaction findByTxnId(String txnId);

}
