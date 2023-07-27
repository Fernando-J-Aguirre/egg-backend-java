package ejercicios14a21;

import java.util.Scanner;

public class Ejercicio16 {

    /*Realizar un algoritmo que rellene un vector de tamaño N con valores aleatorios y le pida al
usuario un numero a buscar en el vector. El programa mostrará donde se encuentra el
numero y si se encuentra repetido*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese tamaño del vector");
        int n = leer.nextInt();

        int[] vector = rellenarVectorRandom(n);

        System.out.println("Ingrese número del 0 a 9 para buscar en el vector");
        int num = leer.nextInt();
        int contador = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == num && contador == 0) {
                System.out.println("El número " + num + " está en la posición [" + i + "]");
                contador++;
            } else if (vector[i] == num && contador > 0) {
                System.out.println("El número " + num + " está repetido y también está en la posición [" + i + "]");
            }           
        }
        if (contador == 0) System.out.println("El número no se encuentra en el vector");

    }

    public static int[] rellenarVectorRandom(int n) {

        int[] vector = new int[n];

        for (int i = 0; i < n - 1; i++) {
            vector[i] = (int) (Math.random() * 10);
        }
        return vector;
    }

}
