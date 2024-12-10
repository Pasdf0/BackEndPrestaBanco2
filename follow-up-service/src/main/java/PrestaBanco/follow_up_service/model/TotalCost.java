package PrestaBanco.follow_up_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCost {
    private double monthlyInterest;
    private double desgravamen;
    private int incendio;
    private int adminFee;
    private int totalFee;
    private int totalCost;
}