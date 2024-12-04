package PrestaBanco.simulate_service.service;

import org.springframework.stereotype.Service;

@Service
public class SimulateService {

    public Integer simulateCredit (int loanAmount, double interestRate, int loanTerm) {
        double monthlyInterest = (interestRate / 12) / 100;
        int payments = loanTerm * 12;
        double temp1 = monthlyInterest * Math.pow(1 + monthlyInterest, payments);
        double temp2 = Math.pow(1 + monthlyInterest, payments) - 1;
        double fee = (loanAmount * temp1) / temp2;
        return (int) fee;
    }
}
