package PrestaBanco.follow_up_service.controller;

import PrestaBanco.follow_up_service.model.Loan;
import PrestaBanco.follow_up_service.model.TotalCost;
import PrestaBanco.follow_up_service.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow-up")
@CrossOrigin("*")
public class FollowUpController {
    @Autowired
    FollowUpService followUpService;

    @GetMapping("/")
    public ResponseEntity<TotalCost> totalCost(@RequestBody Loan loan) {
        try {
            return ResponseEntity.ok(followUpService.calculate(loan));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
