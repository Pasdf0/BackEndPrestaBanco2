package PrestaBanco.evaluate_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String rut;
    private String name;
    private String lastName;
    private String email;
    private String birthdate;
    private String password;
    private String type; //Client - Executive
}