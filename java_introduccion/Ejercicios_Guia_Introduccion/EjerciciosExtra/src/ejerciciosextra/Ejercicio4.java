package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio4 {

    /*Elaborar un algoritmo en el cuál se ingrese un número entre 1 y 10 y se muestre su
equivalente en romano.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número del 1 al 39 para convertir a romano"); //hasta el 39 porque en el 40 ya aparece otra letra "XL"
        int num = leer.nextInt();
        String romano = convertirARomano(num);
        System.out.println("Número: " + num);
        System.out.println("Número romano:  " + romano);
    }

    public static String convertirARomano(int num) {
        String[] romanos = {"X", "IX", "V", "IV", "I"};
        int[] numeros = {10, 9, 5, 4, 1};
        String romano = "";
        int i = 0;
        while (num > 0) {
            if (num >= numeros[i]) {
                romano += romanos[i];
                num -= numeros[i];
            } else {
                i++;
            }
        }
        return romano;
    }

}
