package ejercicios14a21;

import java.util.Scanner;

public class Ejercicio20 {

    /*Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la
suma de sus filas, sus columnas y sus diagonales son idénticas. Crear un programa que
permita introducir un cuadrado por teclado y determine si este cuadrado es mágico o no.
El programa deberá comprobar que los números introducidos son correctos, es decir,
están entre el 1 y el 9.*/
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];

        llenarMatriz(matriz);
        Ejercicio18.mostrarMatriz(matriz);
        boolean magic = esMagico(matriz);
        if (magic) {
            System.out.println("El cuadrado ES mágico");
        } else {
            System.out.println("El cuadrado NO ES mágico");
        }

    }

    public static void llenarMatriz(int[][] matriz) {
        Scanner leer = new Scanner(System.in);
        int n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.println("Ingrese número e/ 1 y 9 para posición: " + "[" + i + "]" + "[" + j + "]");
                    n = leer.nextInt();
                } while (n < 1 || n > 9);
                matriz[i][j] = n;
            }
        }
    }

    public static boolean esMagico(int[][] matriz) {
        boolean magic = true;

        int suma = 0;
        int provisorio = 0;

        //calculo el valor de la primera fila
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[0][i];
        }
        System.out.println("SUMA = " + suma);

        //comparo el valor de suma con todas las filas, si es distinto cambio el valor de magic y corto el ciclo
        for (int i = 0; i < matriz.length; i++) {
            provisorio = 0;
            for (int j = 0; j < matriz.length; j++) {
                provisorio += matriz[i][j];
            }
            System.out.println("PROVISORIO EN FILA " + (i + 1) + " = " + provisorio);
            if (provisorio != suma) {
                magic = false;
                break;
            }
        }

        //comparo el valor de suma con todas las columnas
        for (int j = 0; j < matriz.length; j++) {
            provisorio = 0;
            for (int i = 0; i < matriz.length; i++) {
                provisorio += matriz[i][i];
            }
            System.out.println("PROVISORIO EN COLUMNA " + (j + 1) + " = " + provisorio);
            if (provisorio != suma) {
                magic = false;
                break;
            }
        }

        provisorio = 0;
        //comparo diagonal 1
        for (int i = 0; i < matriz.length; i++) {
            provisorio += matriz[i][i];
        }
        System.out.println("PROVISORIO EN DIAGONAL 1 = " + provisorio);

        provisorio = 0;

        //comparo diagonal2
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i + j == matriz.length - 1) {
                    provisorio += matriz[i][j];
                }
            }
        }

        System.out.println("PROVISORIO EN DIAGONAL 2 = " + provisorio);

        if (provisorio != suma) {
            magic = false;
        }

        return magic;
    }

}
