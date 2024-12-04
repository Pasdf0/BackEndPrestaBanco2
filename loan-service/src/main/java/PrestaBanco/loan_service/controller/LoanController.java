package PrestaBanco.loan_service.controller;

import PrestaBanco.loan_service.entity.LoanEntity;
import PrestaBanco.loan_service.model.Document;
import PrestaBanco.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/loan")
@CrossOrigin("*")
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping("/{id}")
    public ResponseEntity<LoanEntity> getLoanById(@PathVariable Long id) {
        LoanEntity loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanEntity>> getLoanList() {
        List<LoanEntity> loans = loanService.getLoanList();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<LoanEntity>> getLoanByClient(@PathVariable Long id) {
        List<LoanEntity> loans = loanService.getLoanByClient(id);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/exec/{id}")
    public ResponseEntity<List<LoanEntity>> getLoanByExec(@PathVariable Long id) {
        List<LoanEntity> loans = loanService.getLoanByExec(id);
        return ResponseEntity.ok(loans);
    }

    @PostMapping("/")
    public ResponseEntity<LoanEntity> saveLoan(@RequestBody LoanEntity loan) {
        LoanEntity newLoan = loanService.saveLoan(loan);
        return ResponseEntity.ok(newLoan);
    }

    @PutMapping("/")
    public ResponseEntity<LoanEntity> updateLoan(@RequestBody LoanEntity loan) {
        LoanEntity loanUpdated = loanService.updateLoan(loan);
        return ResponseEntity.ok(loanUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) throws Exception {
        boolean bool = loanService.deleteLoan(id);
        if (bool) {
            return ResponseEntity.ok("Loan deleted succesfully");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //Simulate
    @PostMapping("/simulate")
    public ResponseEntity<Integer> simulateCredit(@RequestBody LoanEntity loan) {
        int result = loanService.simulateCredit(loan);
        return ResponseEntity.ok(result);
    }

    //Evaluation
    @GetMapping("/age/{id}")
    public ResponseEntity<Integer> getAge(@PathVariable Long id) {
        Integer age = loanService.getAge(id);
        if (age == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(age);
    }

    //Document
    @GetMapping("/getDocuments/{id}")
    public ResponseEntity<List<Document>> getDocuments(@PathVariable Long id) {
        List<Document> documents = loanService.getDocuments(id);
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/saveDocuments/{id}")
    public ResponseEntity<String> uploadMultipleFiles (
            @PathVariable Long id,
            @RequestParam("documents") MultipartFile[] files) {

        try {
            return ResponseEntity.ok(loanService.saveDocuments(id, files));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading documents");
        }
    }
}