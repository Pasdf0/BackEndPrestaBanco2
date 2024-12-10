package PrestaBanco.follow_up_service.service;

import PrestaBanco.follow_up_service.model.Loan;
import PrestaBanco.follow_up_service.model.TotalCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FollowUpService {
    @Autowired
    RestTemplate restTemplate;

    public TotalCost calculate(Loan loan) {
        TotalCost totalCost = new TotalCost();

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<Loan> requestEntity = new HttpEntity<>(loan, headers);

        // Send POST request
        String url = "http://simulate-service/simulate/";
        ResponseEntity<Integer> feeResponse = restTemplate.postForEntity(
                url,
                requestEntity,
                Integer.class
        );

        int fee = feeResponse.getBody();
        double monthlyInterest = (double) Math.round((loan.getInterestRate() * 100 / 12 ) / 100);
        int desgravamen = (int) ((loan.getLoanAmount() * 0.03) / 100);
        int adminFee = (int) (0.01 * loan.getLoanAmount());
        int totalFee = fee + desgravamen + 20000;
        int cost = totalFee * 12 + loan.getLoanTerm() + adminFee;

        totalCost.setMonthlyInterest(monthlyInterest);
        totalCost.setDesgravamen(desgravamen);
        totalCost.setIncendio(20000);
        totalCost.setAdminFee(adminFee);
        totalCost.setTotalFee(totalFee);
        totalCost.setTotalCost(cost);

        return totalCost;
    }
}
