package PrestaBanco.evaluate_service.service;

import PrestaBanco.evaluate_service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EvaluateService {
    @Autowired
    RestTemplate restTemplate;

    public Integer getAge(Long id) {
        try {
            Client client = restTemplate.getForObject("http://client-service/client/" + id, Client.class);
            String birthDateString = client.getBirthdate();
            if (birthDateString.isEmpty()) {
                return 0;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } catch (Exception e) {
            return 0;
        }
    }
}
