package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio8 {

    /*Escriba un programa que lea números enteros. Si el número es múltiplo de cinco debe
detener la lectura y mostrar la cantidad de números leídos, la cantidad de números pares y
la cantidad de números impares. Al igual que en el ejercicio anterior los números
negativos no deben sumarse. Nota: recordar el uso de la sentencia break.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Digite cantidad de números que va a ingresar");
        int cantidad = leer.nextInt();
        int contador = 0;
        int pares = 0;
        int impares = 0;
        int numero;

        while (cantidad > contador) {
            System.out.println("Ingrese un número entero");
            numero = leer.nextInt();
            if (numero % 5 == 0) {
                break;
            } else if (numero % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
            contador++;
        }

        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
        System.out.println("Total leídos: " + contador);

    }

}
