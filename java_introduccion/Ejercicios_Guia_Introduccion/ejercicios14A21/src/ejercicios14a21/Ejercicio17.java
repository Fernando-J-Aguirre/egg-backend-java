package ejercicios14a21;

import static java.lang.Math.abs;
import java.util.Random;

public class Ejercicio17 {

    /*Recorrer un vector de N enteros contabilizando cuántos números son de 1 dígito, cuántos
de 2 dígitos, etcétera (hasta 5 dígitos).*/
    public static void main(String[] args) {

        int[] vector = rellenarVectorRandom(5);
        int unD, dosD, tresD, cuaD, cincD;
        unD = 0;
        dosD = 0;
        tresD = 0;
        cuaD = 0;
        cincD = 0;
        for (int i = 0; i < vector.length; i++) {
            switch (contarDigitos(vector[i])) {
                case 5:
                    cincD++;
                    break;
                case 4:
                    cuaD++;
                    break;
                case 3:
                    tresD++;
                    break;
                case 2:
                    dosD++;
                    break;
                default:
                    unD++;
                    break;
            }
            System.out.print(vector[i] + " - ");
        }
        System.out.println("");
        System.out.println("Cantidad de valores de 1 dígito: " + unD);
        System.out.println("Cantidad de valores de 2 dígito: " + dosD);
        System.out.println("Cantidad de valores de 3 dígito: " + tresD);
        System.out.println("Cantidad de valores de 4 dígito: " + cuaD);
        System.out.println("Cantidad de valores de 5 dígito: " + cincD);
    }

    public static int[] rellenarVectorRandom(int n) {
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = randomHastaCincoDigitos(1, 99999);
        }
        return vector;
    }

    public static int randomHastaCincoDigitos(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max - min + 1) + min;
        return result;
    }

    public static int contarDigitos(int num) {
        int result = 0;
        while (num != 0) {
            num = abs(num / 10);
            result++;
        }
        return result;
    }
}
