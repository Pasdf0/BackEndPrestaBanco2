package PrestaBanco.evaluate_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EvaluateService {
    @Autowired
    RestTemplate restTemplate;

    public Integer getAge(Long id) {
        try {
            return restTemplate.getForObject("http://client-service/client/getAge/" + id, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }
}
