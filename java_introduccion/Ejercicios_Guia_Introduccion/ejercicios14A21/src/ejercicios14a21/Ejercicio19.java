package ejercicios14a21;

import java.util.Scanner;

public class Ejercicio19 {

    /*Realice un programa que compruebe si una matriz dada es anti simétrica. Se dice que una
matriz A es anti simétrica cuando ésta es igual a su propia traspuesta, pero cambiada de
signo. Es decir, A es anti simétrica si A = -AT. La matriz traspuesta de una matriz A se
denota por AT y se obtiene cambiando sus filas por columnas (o viceversa).*/
    public static void main(String[] args) {

        int[][] matriz = new int[2][2];
//        matriz[0][0] = 0;
//        matriz[0][1] = 1;
//        matriz[1][0] = -1;
//        matriz[1][1] = 0;

        Ejercicio18.rellenarMatriz(matriz); //habría que acomodar este método porque rellena solo con valores positivos, arriba esta la prueba manual y funciona.
        Ejercicio18.mostrarMatriz(matriz);
        System.out.println("Traspuesta");
        mostrarTraspuesta(matriz);
        boolean esAnti = esAntiSimetrica(matriz);
        
        System.out.println("La matriz es AntiSimetrica? = " + esAnti );

    }

    public static boolean esAntiSimetrica(int[][] matriz) {
        boolean antiSimetrica = true;
        int[][] matrizAux = new int[matriz.length][matriz.length];

        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz[j].length; i++) {
                matrizAux[j][i] = matriz[i][j];
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != (-1 * matrizAux[i][j])) {
                    antiSimetrica = false;
                    break;
                }
            }
        }

        return antiSimetrica;
    }

    public static void mostrarTraspuesta(int[][] matriz) {
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz[j].length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
