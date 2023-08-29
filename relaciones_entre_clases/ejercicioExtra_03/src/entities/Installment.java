package entities;

import java.time.LocalDate;

public class Installment {

    private int number;
    private double totalAmount;
    private boolean paid;
    private LocalDate dueDate;
    private String paymentMethod;

    public Installment() {
    }

    public Installment(int number, double totalAmount, boolean paid, LocalDate dueDate, String paymentMethod) {
        this.number = number;
        this.totalAmount = totalAmount;
        this.paid = paid;
        this.dueDate = dueDate;
        this.paymentMethod = paymentMethod;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Installment{" + "number=" + number + ", totalAmount=" + totalAmount + ", paid=" + paid + ", dueDate=" + dueDate + ", paymentMethod=" + paymentMethod + '}';
    }

    

}
