package services;

import entities.Operacion;
import java.util.Scanner;

public class OperacionService {

    public Operacion crearOperacion() {
        Operacion op = new Operacion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero 1");
        op.setNumero1(scanner.nextInt());
        System.out.println("Ingrese numero 2");
        op.setNumero2(scanner.nextInt());
        return op;
    }

    public int sumar(Operacion op) {
        int suma = op.getNumero1() + op.getNumero2();
        return suma;
    }

    public int restar(Operacion op) {
        int resta = op.getNumero1() - op.getNumero2();
        return resta;
    }

    public int multiplicar(Operacion op) {
        int multiplicar = op.getNumero1() * op.getNumero2();
        if (op.getNumero1() == 0 || op.getNumero2() == 0) {
            System.out.println("Inválido. Multiplicación por cero");
            multiplicar = 0;
        }
        return multiplicar;
    }
    
    public int dividir(Operacion op) {
        int division = op.getNumero1() / op.getNumero2();
        if (op.getNumero1() == 0 || op.getNumero2() == 0) {
            System.out.println("Inválido. División por cero");
            division = 0;
        }
        return division;
    }
    
}
