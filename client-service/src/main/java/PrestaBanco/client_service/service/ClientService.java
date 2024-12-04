package PrestaBanco.client_service.service;

import PrestaBanco.client_service.entity.ClientEntity;
import PrestaBanco.client_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RestTemplate restTemplate;

    public ClientEntity getClientById(Long id) {return clientRepository.findById(id).get();}

    public ClientEntity clientLogin(String email, String password) {
        ClientEntity user = clientRepository.findByEmail(email);
        if (password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public ClientEntity saveClient(ClientEntity client) {
        String hashedPassword = hashPassword(client.getPassword());
        client.setPassword(hashedPassword);
        return clientRepository.save(client);
    }

    public ClientEntity updateClient(ClientEntity client) {
        if (client.getId() == null) {
            return null;
        }
        return clientRepository.save(client);
    }

    public boolean deleteClient(Long id) throws Exception {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //For evaluation
    public int getAge(Long id) {
        String birthDateString = getClientById(id).getBirthdate();
        if (birthDateString == null) {
            return 0;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashedPassword = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
