package PrestaBanco.loan_service.service;

import PrestaBanco.loan_service.entity.LoanEntity;
import PrestaBanco.loan_service.model.TotalCost;
import PrestaBanco.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    RestTemplate restTemplate;

    public LoanEntity getLoanById(Long id) {return loanRepository.findById(id).get();}
    public List<LoanEntity> getLoanList() {return loanRepository.findAllNew();}
    public ArrayList<LoanEntity> getLoanByExec(Long execId) {return loanRepository.findByExecId(execId);}
    public ArrayList<LoanEntity> getLoanByClient(Long clientId) {return loanRepository.findByClientId(clientId);}
    public LoanEntity saveLoan(LoanEntity loan) {return loanRepository.save(loan);}
    public LoanEntity updateLoan(LoanEntity loan) {return loanRepository.save(loan);}

    public boolean deleteLoan(Long id) throws Exception {
        try {
            loanRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Simulate
    public Integer simulateCredit (int loanAmount, int loanTerm, double interestRate) {
        String url = "http://simulate-service/simulate/?loanAmount=" + loanAmount + "&loanTerm=" + loanTerm + "&interestRate=" + interestRate;
        return restTemplate.getForObject(url, Integer.class);
    }

    //FollowUp
    public TotalCost getTotalCost(int loanAmount, int loanTerm, double interestRate) {
        String url = "http://follow-up-service/follow-up/?loanAmount=" + loanAmount + "&loanTerm=" + loanTerm + "&interestRate=" + interestRate;
        return restTemplate.getForObject(url, TotalCost.class);
    }

    //Evaluation
    public Integer getAge(Long id) {
        try {
            return restTemplate.getForObject("http://evaluate-service/evaluate/getAge/" + id, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }
}
