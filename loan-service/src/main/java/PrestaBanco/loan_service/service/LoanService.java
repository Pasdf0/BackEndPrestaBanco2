package PrestaBanco.loan_service.service;

import PrestaBanco.loan_service.entity.LoanEntity;
import PrestaBanco.loan_service.model.Document;
import PrestaBanco.loan_service.model.TotalCost;
import PrestaBanco.loan_service.repository.LoanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.*;

import java.io.IOException;
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
    public Integer simulateCredit (LoanEntity loan) {
        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<LoanEntity> requestEntity = new HttpEntity<>(loan, headers);

        // Send POST request
        String url = "http://simulate-service/simulate/";
        ResponseEntity<Integer> response = restTemplate.postForEntity(
                url,
                requestEntity,
                Integer.class
        );

        return response.getBody();
    }

    //FollowUp
    public TotalCost getTotalCost(LoanEntity loan) {
        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<LoanEntity> requestEntity = new HttpEntity<>(loan, headers);

        // Send POST request
        String url = "http://follow-up-service/follow-up/";
        ResponseEntity<TotalCost> response = restTemplate.postForEntity(
                url,
                requestEntity,
                TotalCost.class
        );

        return response.getBody();
    }

    //Evaluation
    public Integer getAge(Long id) {
        try {
            return restTemplate.getForObject("http://evaluate-service/evaluate/getAge/" + id, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }

    //Documents
    public List<Document> getDocuments(Long id) {
        return restTemplate.getForObject("http://document-service/document/" + id, List.class);
    }

    public String saveDocuments(Long id, MultipartFile[] files) throws IOException {
        ArrayList<Document> documents = new ArrayList<>();
        for (MultipartFile file : files) {
            Document doc = new Document();
            doc.setLoanId(id);
            try {
                doc.setDocument(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            documents.add(doc);
        }

        // Convert documents to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonDocuments = objectMapper.writeValueAsString(documents);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonDocuments, headers);

        // Send POST request
        String url = "http://document-service/document/";
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return response.getBody();
    }
}
