package com.example.jbdl.ewallet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

//    @Autowired
//    ObjectMapper objectMapper;

    @Value("${user.onboarding.amount}")
    Double onboardingAmount;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    WalletRepository walletRepository;

    private static final String USER_CREATE_TOPIC = "user_create";
    private static final String TXN_CREATE_TOPIC = "txn_create";
    private static final String WALLET_UPDATE_TOPIC = "wallet_update";


    @KafkaListener(topics = {USER_CREATE_TOPIC}, groupId = "jdbl61_grp")
    public void walletCreate(String message) throws Exception {

        JSONObject jsonObject = (JSONObject) new JSONParser().parse(message);

        if(!jsonObject.containsKey("userId")){
            throw new Exception("userId is not present in the user event");
        }

        int userId = ((Long) jsonObject.get("userId")).intValue();

        Wallet wallet = Wallet.builder()
                .balance(onboardingAmount)
                .userId(userId)
                .build();

        walletRepository.save(wallet);
    }

    @KafkaListener(topics = {TXN_CREATE_TOPIC}, groupId = "jbdl27_grp")
    public void walletUpdate(String msg) throws Exception {

        JSONObject jsonObject = (JSONObject) new JSONParser().parse(msg);

        if(!jsonObject.containsKey("sender") ||
                !jsonObject.containsKey("receiver") ||
                !jsonObject.containsKey("amount") ||
                !jsonObject.containsKey("txnId")){
            throw new Exception("some of the details are not present in the txn create event");
        }

        Integer receiverId = ((Long) jsonObject.get("receiver")).intValue();
        Integer senderId = ((Long) jsonObject.get("sender")).intValue();
        Double amount = (Double) jsonObject.get("amount");
        String txnId = (String) jsonObject.get("txnId");

        JSONObject walletUpdateEvent = new JSONObject();
        walletUpdateEvent.put("txnId", txnId);

        Wallet senderWallet = walletRepository.findByUserId(senderId);
        if(senderWallet.getBalance() < amount){
            // This status is telling about the wallet updation whether it's successful or not
            walletUpdateEvent.put("status", "FAILED");
        }else{
            walletRepository.updateWallet(receiverId, amount);
            walletRepository.updateWallet(senderId, 0 - amount);
            walletUpdateEvent.put("status", "SUCCESSFUL");
        }

        kafkaTemplate.send(WALLET_UPDATE_TOPIC, walletUpdateEvent.toJSONString());
    }
}
