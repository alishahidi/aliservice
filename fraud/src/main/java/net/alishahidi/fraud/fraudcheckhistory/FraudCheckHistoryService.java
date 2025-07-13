package net.alishahidi.fraud.fraudcheckhistory;

import org.springframework.stereotype.Service;

@Service
public record FraudCheckHistoryService(
        FraudCheckHistoryRepository fraudCheckHistoryRepository
) {

    public Boolean isFraudulentCustomer(Long customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .build()
        );
        return false;
    }
}
