package services;

import entities.Installment;
import java.time.LocalDate;
import java.util.Scanner;

public class InstallmentService {
    
    private Scanner sc;
    private Installment installment;
    
    public InstallmentService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        installment = new Installment();
    }
    
    public Installment createInstallment(int installmentNumber, double totalAmount, int months) {
         installment.setNumber(installmentNumber);
        installment.setTotalAmount(totalAmount / months);
        installment.setPaid(false);
        LocalDate now = LocalDate.now();
        LocalDate dueDate = now.plusDays(30);
        installment.setDueDate(dueDate);
        installment.setPaymentMethod("Direct debit"); 
        return installment;
    }
    
    
    
}
