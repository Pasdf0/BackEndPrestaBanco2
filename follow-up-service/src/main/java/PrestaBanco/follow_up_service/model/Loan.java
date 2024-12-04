package PrestaBanco.follow_up_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private Long id;
    private int propertyCost;
    private int loanAmount;
    private int loanTerm;
    private double interestRate;
    private String type;
    private Long clientId;
    private Long execId;
    private Boolean cancelled;
    private String executiveMessage;
    private String state;
}