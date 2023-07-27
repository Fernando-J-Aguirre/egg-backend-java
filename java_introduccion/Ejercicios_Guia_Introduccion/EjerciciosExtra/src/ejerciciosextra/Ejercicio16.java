package ejerciciosextra;

import java.util.Scanner;

/*Diseñe una función que pida el nombre y la edad de N personas e imprima los datos de
las personas ingresadas por teclado e indique si son mayores o menores de edad.
Después de cada persona, el programa debe preguntarle al usuario si quiere seguir
mostrando personas y frenar cuando el usuario ingrese la palabra “No”.*/
public class Ejercicio16 {

    public static void main(String[] args) {
        boolean continuar;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese nombre de la persona");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la edad de " + nombre);
            int edad = scanner.nextInt();
            if (edad >= 18) {
                System.out.println(nombre + " es mayor de edad");
            } else {
                System.out.println(nombre + " es menor de edad");
            }
            scanner.nextLine();
            System.out.println("¿Quiere continuar mostrando personas? S/N");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        } while (continuar);

    }

}
