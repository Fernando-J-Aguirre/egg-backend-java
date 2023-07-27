package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio1 {

    /*Dado un tiempo en minutos, calcular su equivalente en días y horas. Por ejemplo, si el
usuario ingresa 1600 minutos, el sistema debe calcular su equivalente: 1 día, 2 horas.*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese cantidad de minutos");
        int minutos = leer.nextInt();

        int horas = (minutos / 60) % 24;
        int dias = (minutos / 60) / 24;
        minutos %= 60;

        System.out.println(dias + " días, " + horas + " horas y " + minutos + " minutos");

    }

}
