package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio2 {

    /*Declarar cuatro variables de tipo entero A, B, C y D y asignarle un valor diferente a cada
una. A continuación, realizar las instrucciones necesarias para que: B tome el valor de C, C
tome el valor de A, A tome el valor de D y D tome el valor de B. Mostrar los valores
iniciales y los valores finales de cada variable. Utilizar sólo una variable auxiliar.*/
    public static void main(String[] args) {
        String[] arrayString = {"A", "B", "C", "D"};
        int[] arrayValores = new int[4];
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el valor de " + arrayString[i]);
            arrayValores[i] = leer.nextInt();
        }
        
        mostrar(arrayValores);
        intercambiar(arrayValores);
        System.out.println("");
        mostrar(arrayValores);
    }

    public static void intercambiar(int[] vector) {
        int aux1, aux2;

        aux1 = vector[2];
        vector[2] = vector[0];
        aux2 = vector[1];
        vector[1] = aux1;
        aux1 = vector[3];
        vector[3] = aux2;
        aux2 = vector[0];
        vector[0] = aux1;
    }

    public static void mostrar(int[] vector) {
        System.out.println("Valor de A = " + vector[0]);
        System.out.println("Valor de B = " + vector[1]);
        System.out.println("Valor de C = " + vector[2]);
        System.out.println("Valor de D = " + vector[3]);
    }
}
