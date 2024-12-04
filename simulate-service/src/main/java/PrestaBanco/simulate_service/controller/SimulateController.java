package PrestaBanco.simulate_service.controller;

import PrestaBanco.simulate_service.model.Loan;
import PrestaBanco.simulate_service.service.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
@CrossOrigin("*")
public class SimulateController {
    @Autowired
    SimulateService simulateService;

    @GetMapping("/")
    public ResponseEntity<Integer> simulateCredit(@RequestBody Loan loan) {
        Integer fee = simulateService.simulateCredit(loan.getLoanAmount(), loan.getInterestRate(), loan.getLoanTerm());
        return ResponseEntity.ok(fee);
    }
}