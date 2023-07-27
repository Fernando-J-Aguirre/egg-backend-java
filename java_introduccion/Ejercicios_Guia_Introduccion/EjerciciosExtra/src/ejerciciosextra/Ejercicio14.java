package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio14 {

    /*Se dispone de un conjunto de N familias, cada una de las cuales tiene una M cantidad de
hijos. Escriba un programa que pida la cantidad de familias y para cada familia la cantidad
de hijos para averiguar la media de edad de los hijos de todas las familias.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de familias:");
        int cantidadFamilias = scanner.nextInt();

        int totalHijos = 0;
        int totalEdad = 0;

        for (int i = 1; i <= cantidadFamilias; i++) {
            System.out.println("Ingrese la cantidad de hijos para la familia " + i + ":");
            int cantidadHijos = scanner.nextInt();

            for (int j = 1; j <= cantidadHijos; j++) {
                System.out.println("Ingrese la edad del hijo " + j + " de la familia " + i + ":");
                int edadHijo = scanner.nextInt();
                totalEdad += edadHijo;
                totalHijos++;
            }
        }

        int mediaEdad = (int) Math.floor(totalEdad / totalHijos);

        System.out.println("La media de edad de los hijos de todas las familias es: " + mediaEdad);
    }
}
