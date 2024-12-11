package PrestaBanco.follow_up_service.service;

import PrestaBanco.follow_up_service.model.TotalCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FollowUpService {
    @Autowired
    RestTemplate restTemplate;

    public TotalCost calculate(int loanAmount, int loanTerm, double interestRate) {
        TotalCost totalCost = new TotalCost();

        String url = "http://simulate-service/simulate/?loanAmount=" + loanAmount + "&loanTerm=" + loanTerm + "&interestRate=" + interestRate;
        Integer fee = restTemplate.getForObject(url, Integer.class);

        int temp = (int)(interestRate * 100 / 12);
        double monthlyInterest = (double) temp / 100;
        int desgravamen = (int) ((loanAmount * 0.03) / 100);
        int adminFee = (int) (0.01 * loanAmount);
        int totalFee = fee + desgravamen + 20000;
        int cost = totalFee * 12 + loanTerm + adminFee;

        totalCost.setMonthlyInterest(monthlyInterest);
        totalCost.setDesgravamen(desgravamen);
        totalCost.setIncendio(20000);
        totalCost.setAdminFee(adminFee);
        totalCost.setTotalFee(totalFee);
        totalCost.setTotalCost(cost);

        return totalCost;
    }
}
