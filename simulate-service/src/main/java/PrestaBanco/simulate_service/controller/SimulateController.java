package PrestaBanco.simulate_service.controller;

import PrestaBanco.simulate_service.model.Loan;
import PrestaBanco.simulate_service.service.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
public class SimulateController {
    @Autowired
    SimulateService simulateService;

    @GetMapping("/")
    public ResponseEntity<Integer> simulateCredit(
            @RequestParam int loanAmount,
            @RequestParam int loanTerm,
            @RequestParam double interestRate
    ) {
        Integer fee = simulateService.simulateCredit(loanAmount, interestRate, loanTerm);
        return ResponseEntity.ok(fee);
    }
}