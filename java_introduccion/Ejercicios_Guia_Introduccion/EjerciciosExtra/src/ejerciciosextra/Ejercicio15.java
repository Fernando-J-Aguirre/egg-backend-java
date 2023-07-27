package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio15 {

    /*Crea una aplicación que le pida dos números al usuario y este pueda elegir entre sumar,
restar, multiplicar y dividir. La aplicación debe tener una función para cada operación
matemática y deben devolver sus resultados para imprimirlos en el main.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double numero2 = scanner.nextDouble();

        System.out.println("Seleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        int opcion = scanner.nextInt();

        double resultado;

        switch (opcion) {
            case 1:
                resultado = sumar(numero1, numero2);
                break;
            case 2:
                resultado = restar(numero1, numero2);
                break;
            case 3:
                resultado = multiplicar(numero1, numero2);
                break;
            case 4:
                resultado = dividir(numero1, numero2);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        System.out.println("El resultado es: " + resultado);
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}
