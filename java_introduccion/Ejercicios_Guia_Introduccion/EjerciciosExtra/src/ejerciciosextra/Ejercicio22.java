package ejerciciosextra;

import java.util.Random;

/*Realizar un programa que rellene una matriz de tamaño NxM con valores aleatorios y
muestre la suma de sus elementos.*/

public class Ejercicio22 {

    public static void main(String[] args) {

        int[][] matriz = generarMatrizAleatoria(3, 4);

        mostrarMatriz(matriz);

        int suma = calcularSumaMatriz(matriz);

        System.out.println("La suma de los elementos de la matriz es: " + suma);
    }

    public static int[][] generarMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(20); // Genera un número aleatorio entre 0 y 19
            }
        }

        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int calcularSumaMatriz(int[][] matriz) {
        int suma = 0;
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
}
