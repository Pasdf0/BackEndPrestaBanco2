package PrestaBanco.follow_up_service.model;

public class TotalCost {
    private double monthlyInterest;
    private double desgravamen;
    private int incendio;
    private int adminFee;
    private int totalFee;
    private int totalCost;

    public TotalCost() {
    }

    public TotalCost(double monthlyInterest, double desgravamen, int incendio, int adminFee, int totalFee, int totalCost) {
        this.monthlyInterest = monthlyInterest;
        this.desgravamen = desgravamen;
        this.incendio = incendio;
        this.adminFee = adminFee;
        this.totalFee = totalFee;
        this.totalCost = totalCost;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public double getDesgravamen() {
        return desgravamen;
    }

    public void setDesgravamen(double desgravamen) {
        this.desgravamen = desgravamen;
    }

    public int getIncendio() {
        return incendio;
    }

    public void setIncendio(int incendio) {
        this.incendio = incendio;
    }

    public int getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}