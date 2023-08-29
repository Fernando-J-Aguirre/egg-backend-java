package services;

import entities.Installment;
import entities.Policy;
import entities.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyService {

    private Scanner sc;
    private InstallmentService installmentService;
    private ArrayList<Installment> installments;
    private ArrayList<Policy> policies;

    public PolicyService(InstallmentService installmentService) {
        sc = new Scanner(System.in).useDelimiter("\n");
        this.installmentService = installmentService;
        installments = new ArrayList<>();
        policies = new ArrayList<>();
    }

    public Policy createPolicy() {
        Policy policy = new Policy();
        System.out.println("Ingrese número de póliza");
         policy.setPolicyNumber(sc.nextInt());
        LocalDate now = LocalDate.now();
        policy.setStartDate(now);
        System.out.println("Ingrese la cantidad de meses de la póliza");
        int months = sc.nextInt();
        LocalDate expirationDate = now.plusMonths(months);
        policy.setExpirationDate(expirationDate);
        System.out.println("Ingrese el monto total asegurado");
        double totalInsuredAmount = sc.nextDouble();
        policy.setTotalInsuredAmount(totalInsuredAmount);
        System.out.println("Desea incluir cobertura contra granizo? S/N");
        if (sc.next().equalsIgnoreCase("s")) {
            policy.setIncludesHailCoverage(true);
            System.out.println("Ingrese monto Maximo contra granizo");
            policy.setMaxHailAmount(sc.nextDouble());
        } else {
            policy.setIncludesHailCoverage(false);
            policy.setMaxHailAmount(0);
        }
        System.out.println("Ingrese tipo de cobertura");
        policy.setCoverageType(sc.next());
        for (int i = 0; i < months; i++) {
            Installment installment = installmentService.createInstallment((i + 1), totalInsuredAmount, months);
            installments.add(installment);
        }
        policy.setInstallments(installments);
        policies.add(policy);
        return policy;
    }

    public Policy getByPolicyNumber(int number) {
        for (Policy policy : policies) {
            if (policy.getPolicyNumber() == number) {
                return policy;
            }
        }
        return null;
    }

    public Policy findPolicyByVehicle(Vehiculo vehicle) {
        for (Policy policy : policies) {
            if (vehicle.getPoliza().equals(policy)) {
                return policy;
            }
        }
        return null;
    }

    public ArrayList<Policy> getAllPolicies() {
        return policies;
    }

    public void deletePolicy(Vehiculo vehicle) {
        if (policies.contains(vehicle.getPoliza())) {
            policies.removeAll(vehicle.getPoliza().getInstallments());
            policies.remove(vehicle.getPoliza());
        }
    }
    
}
