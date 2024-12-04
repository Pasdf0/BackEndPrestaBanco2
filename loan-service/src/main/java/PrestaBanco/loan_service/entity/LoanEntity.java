package PrestaBanco.loan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int propertyCost;
    private int loanAmount; //Cliente
    private int loanTerm; //Cliente
    private double interestRate; //Cliente
    private String type; //Cliente
    private Long clientId; //Al crear
    private Long execId; //Null hasta que se revisa
    private Boolean cancelled; //false por defecto
    private String executiveMessage;
    private String state;
}
