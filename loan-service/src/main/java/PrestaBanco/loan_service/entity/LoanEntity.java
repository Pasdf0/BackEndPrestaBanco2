package PrestaBanco.loan_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
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

    public LoanEntity() {
    }

    public LoanEntity(Long id, int propertyCost, int loanAmount, int loanTerm, double interestRate, String type, Long clientId, Long execId, Boolean cancelled, String executiveMessage, String state) {
        this.id = id;
        this.propertyCost = propertyCost;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
        this.type = type;
        this.clientId = clientId;
        this.execId = execId;
        this.cancelled = cancelled;
        this.executiveMessage = executiveMessage;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPropertyCost() {
        return propertyCost;
    }

    public void setPropertyCost(int propertyCost) {
        this.propertyCost = propertyCost;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getExecId() {
        return execId;
    }

    public void setExecId(Long execId) {
        this.execId = execId;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getExecutiveMessage() {
        return executiveMessage;
    }

    public void setExecutiveMessage(String executiveMessage) {
        this.executiveMessage = executiveMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
