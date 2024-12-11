package PrestaBanco.client_service.controller;

import PrestaBanco.client_service.entity.ClientEntity;
import PrestaBanco.client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        ClientEntity client = clientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping("/login")
    public ResponseEntity<ClientEntity> loginClient(@RequestBody ClientEntity client) {
        String email = client.getEmail();
        String password = clientService.hashPassword(client.getPassword());
        ClientEntity newClient = clientService.clientLogin(email, password);
        return ResponseEntity.ok(newClient);
    }

    @PostMapping("/")
    public ResponseEntity<ClientEntity> registerClient(@RequestBody ClientEntity client) {
        ClientEntity newClient = clientService.saveClient(client);
        if (newClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/")
    public ResponseEntity<ClientEntity> updateClient(@RequestBody ClientEntity client) {
        ClientEntity updatedClient = clientService.updateClient(client);
        if (updatedClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(clientService.deleteClient(id));
    }
}
