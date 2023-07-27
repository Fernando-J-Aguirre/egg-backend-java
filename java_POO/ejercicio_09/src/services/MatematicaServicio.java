package services;

import entities.Matematica;
import java.util.Random;

public class MatematicaServicio {

    Matematica matematica = new Matematica();
    Random random = new Random();

    public void llenarNumeros() {
        matematica.setNum1(random.nextDouble() * 100);
        matematica.setNum2(random.nextDouble() * 100);
    }

    public void devolverMayor() {
        if (matematica.getNum1() > matematica.getNum2()) {
            System.out.println("El mayor valor es el num1 = " + matematica.getNum1());
        } else {
            System.out.println("El mayor valor es el num2 = " + matematica.getNum2());
        }
    }

    public void calcularPotencia() {
        int num1 = (int) Math.floor(matematica.getNum1());
        int num2 = (int) Math.floor(matematica.getNum2());
        if (num1 > num2) {
            System.out.println("num1 ^ num2 = " + (int) Math.pow(num1, num2));
        } else {
            System.out.println("num2 ^ num1 = " + (int) Math.pow(num2, num1));
        }
    }

    public void calcularRaiz() {
        int num1 = (int) Math.abs(matematica.getNum1());
        int num2 = (int) Math.abs(matematica.getNum2());
        if (num1 < num2) {
            int raiz = (int) Math.sqrt(num1);
            System.out.println("La raiz cuadrada del menor valor, en este caso el num1 = " + raiz);
        } else {
            int raiz = (int) Math.sqrt(num2);
            System.out.println("La raiz cuadrada del menor valor, en este caso el num2 = " + raiz);
        }
    }
    
    public String mostrar() {
        return matematica.toString();
    }

}
