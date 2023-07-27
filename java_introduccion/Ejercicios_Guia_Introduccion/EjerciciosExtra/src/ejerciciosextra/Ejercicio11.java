package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio11 {

    /*Escribir un programa que lea un número entero y devuelva el número de dígitos que
componen ese número. Por ejemplo, si introducimos el número 12345, el programa
deberá devolver 5. Calcular la cantidad de dígitos matemáticamente utilizando el operador
de división. Nota: recordar que las variables de tipo entero truncan los números o
resultados.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número");
        int num = leer.nextInt();
        contarDigitos(num);
    }

    public static void contarDigitos(int num) {
        int contador = 0;
        while(num  > 0) {
            contador++;
            num /= 10;
            System.out.println(num);
        }
        System.out.println("El número tiene " + contador + " dígitos");
    }

}
