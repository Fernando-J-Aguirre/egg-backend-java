package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio6 {

    /*Leer la altura de N personas y determinar el promedio de estaturas que se encuentran por
debajo de 1.60 mts. y el promedio de estaturas en general.*/
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese cantidad de personas");
        int total = read.nextInt();
        double[] heigths = new double[total];
        for (int i = 0; i < total; i++) {
            System.out.println("Ingrese altura de persona " + (i + 1));
            heigths[i] = read.nextDouble();
        }

        calculateAverage(heigths);
    }

    public static void calculateAverage(double[] heigths) {
        double generalSum = 0;
        double sumShortP = 0;
        int shortP = 0;
        for (int i = 0; i < heigths.length; i++) {
            if (heigths[i] < 1.60) {
                sumShortP += heigths[i];
                shortP++;
            }
            generalSum += heigths[i];
        }
        System.out.println("Hay " + heigths.length + " personas en total y la estatura promedio es = " + Math.floor((generalSum / heigths.length) * 100) / 100);
        System.out.println("Hay " + shortP + " personas por debajo de 1.60 y la estatura promedio es = " + Math.floor((sumShortP / shortP) * 100) / 100);
    }

}
