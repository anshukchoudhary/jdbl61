package com.example.jbdl.ewallet;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreateRequest {

    @Positive
    private Integer senderUserId;

    @Positive
    private Integer receiverUserId;

    @Positive
    private Double amount;

    private String purpose;

    public Transaction to(){
        return Transaction.builder()
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .amount(amount)
                .purpose(purpose)
                .build();
    }
}
