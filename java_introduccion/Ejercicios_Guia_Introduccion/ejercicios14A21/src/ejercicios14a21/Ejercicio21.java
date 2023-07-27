package ejercicios14a21;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio21 {

    /*Dadas dos matrices cuadradas de números enteros, la matriz M de 10x10 y la matriz P de
3x3, se solicita escribir un programa en el cual se compruebe si la matriz P está contenida
dentro de la matriz M. Para ello se debe verificar si entre todas las submatrices de 3x3 que
se pueden formar en la matriz M, desplazándose por filas o columnas, existe al menos una
que coincida con la matriz P. En ese caso, el programa debe indicar la fila y la columna de
la matriz M en la cual empieza el primer elemento de la submatriz P.*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[][] matrizM = new int[10][10];
        int[][] matrizP = new int[3][3];
        rellenarMatriz(matrizM);
//        rellenarMatriz(matrizP);
        Ejercicio18.mostrarMatriz(matrizM);
        System.out.println("");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizP[i][j] = leer.nextInt();
            }
        }
        Ejercicio18.mostrarMatriz(matrizP);
        comprobarSubmatrices(matrizM, matrizP);
        
    }

    public static void rellenarMatriz(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(4);
            }
        }
    }

    public static void comprobarSubmatrices(int[][] matrizM, int[][] matrizP) {
        boolean verif = false;
        int ii = 0;
        int jj = 0;

        for (int i = 0; i <= matrizM.length - matrizP.length; i++) {
            for (int j = 0; j <= matrizM.length - matrizP.length; j++) {
                if (matrizM[i][j] == matrizP[0][0] && estaContenida(matrizM, matrizP, i, j)) {
                    verif = true;
                    ii = i;
                    jj = j;
                }
            }
        }
        if (verif) {
            System.out.println("La matriz P está contenida dentro de la matriz M en la posición [" + ii + "][" + jj + "]");
        } else {
            System.out.println("La matriz P no está contenida dentro de la matriz M");
        }

    }

    public static boolean estaContenida(int[][] matrizM, int[][] matrizP, int i, int j) {
        boolean verif = true;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (matrizM[k + i][l + j] != matrizP[k][l]) {
                    verif = false;
                    break;
                }
            }
        }
        return verif;
    }

}
