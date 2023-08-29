package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Policy {

    private int policyNumber;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private double totalInsuredAmount;
    private boolean includesHailCoverage;
    private double maxHailAmount;
    private String coverageType;
    private ArrayList<Installment> installments;

    public Policy() {
    }

    public Policy(int policyNumber, LocalDate startDate, LocalDate expirationDate, double totalInsuredAmount, boolean includesHailCoverage, double maxHailAmount, String coverageType, ArrayList<Installment> installments) {
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.totalInsuredAmount = totalInsuredAmount;
        this.includesHailCoverage = includesHailCoverage;
        this.maxHailAmount = maxHailAmount;
        this.coverageType = coverageType;
        this.installments = installments;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getTotalInsuredAmount() {
        return totalInsuredAmount;
    }

    public void setTotalInsuredAmount(double totalInsuredAmount) {
        this.totalInsuredAmount = totalInsuredAmount;
    }

    public boolean isIncludesHailCoverage() {
        return includesHailCoverage;
    }

    public void setIncludesHailCoverage(boolean includesHailCoverage) {
        this.includesHailCoverage = includesHailCoverage;
    }

    public double getMaxHailAmount() {
        return maxHailAmount;
    }

    public void setMaxHailAmount(double maxHailAmount) {
        this.maxHailAmount = maxHailAmount;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public ArrayList<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(ArrayList<Installment> installments) {
        this.installments = installments;
    }

    @Override
    public String toString() {
        return "Policy{" + "policyNumber=" + policyNumber + ", startDate=" + startDate + ", expirationDate=" + expirationDate + ", totalInsuredAmount=" + totalInsuredAmount + ", includesHailCoverage=" + includesHailCoverage + ", maxHailAmount=" + maxHailAmount + ", coverageType=" + coverageType + ", installments=" + installments + '}';
    }

    

}
