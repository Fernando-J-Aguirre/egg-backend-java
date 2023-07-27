package services;

import entities.Cuenta;
import java.util.Scanner;

public class CuentaServicio {
    
    public Cuenta crearCuenta() {
        Cuenta cuenta = new Cuenta();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese número de cuenta");
        cuenta.setNumeroCuenta(scanner.nextInt());
        System.out.println("Ingrese DNI");
        cuenta.setDniCliente(scanner.nextLong());
        System.out.println("Ingrese saldo actual");
        cuenta.setSaldoActual(scanner.nextInt());
        System.out.println("Ingrese interés");
        cuenta.setInteres(scanner.nextDouble());
        return cuenta;
    }
    
    public void ingresar(Cuenta cuenta, double ingreso) {
        int saldo = cuenta.getSaldoActual();
        saldo += ingreso;
        cuenta.setSaldoActual(saldo);
    }
    
    public void retirar(Cuenta cuenta, double retiro) {
        int saldo = cuenta.getSaldoActual();
        if (retiro > saldo) {
            saldo = 0;
        } else {
            saldo -= retiro;
        }
        cuenta.setSaldoActual(saldo);
    }
    
    public void extraccionRapida(Cuenta cuenta, double retiro) {
        int saldo = cuenta.getSaldoActual();
        if (retiro <= saldo * 0.2) {
            saldo -= retiro;
        } else {
            System.out.println("Solo puede sacar hasta un 20% de su saldo actual");
        }
        cuenta.setSaldoActual(saldo);
    }
    
}
