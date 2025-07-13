package net.alishahidi.fraud.fraudcheckhistory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudCheckHistoryController(
        FraudCheckHistoryService fraudCheckHistoryService
) {

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        Boolean fraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);

        log.info("fraudulent customer: {}", fraudulentCustomer);

        return new FraudCheckResponse(fraudulentCustomer);
    }

}
