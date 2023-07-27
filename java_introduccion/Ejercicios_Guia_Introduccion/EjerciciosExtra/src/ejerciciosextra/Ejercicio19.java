package ejerciciosextra;

/*Escriba un programa que averigüe si dos vectores de N enteros son iguales (la
comparación deberá detenerse en cuanto se detecte alguna diferencia entre los
elementos).*/
import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de los vectores: ");
        int n = scanner.nextInt();

        int[] vector1 = new int[n];
        int[] vector2 = new int[n];

        System.out.println("Ingrese los elementos del primer vector:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Ingrese los elementos del segundo vector:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector2[i] = scanner.nextInt();
        }

        boolean sonIguales = true;
        for (int i = 0; i < n; i++) {
            if (vector1[i] != vector2[i]) {
                sonIguales = false;
                break;
            }
        }

        if (sonIguales) {
            System.out.println("Los vectores son iguales");
        } else {
            System.out.println("Los vectores son diferentes");
        }
    }

}
