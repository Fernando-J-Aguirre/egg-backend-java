package ejerciciosextra;

import java.util.Random;
import java.util.Scanner;

/*Construya un programa que lea 5 palabras de mínimo 3 y hasta 5 caracteres y, a medida
que el usuario las va ingresando, construya una “sopa de letras para niños” de tamaño de
20 x 20 caracteres. Las palabras se ubicarán todas en orden horizontal en una fila que
será seleccionada de manera aleatoria. Una vez concluida la ubicación de las palabras,
rellene los espacios no utilizados con un número aleatorio del 0 al 9. Finalmente imprima
por pantalla la sopa de letras creada.
Nota: Para resolver el ejercicio deberá investigar cómo se utilizan las siguientes funciones
de Java substring(), Length() y Math.random().*/
public class Ejercicio23 {

    public static void main(String[] args) {
        String[][] matriz = new String[20][20];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            String palabra;
            do {
                System.out.println("Ingrese palabra número " + (i + 1) + " de tres a cinco caracteres");
                palabra = scanner.nextLine();
            } while (palabra.length() < 3 || palabra.length() > 5 || palabra.contains(" "));
            int columnaRandom = random.nextInt(20 - palabra.length());
            int filaRandom = random.nextInt(20);
            while (!comprobarLugar(matriz, filaRandom, columnaRandom, palabra)) {
                filaRandom = random.nextInt(20);
            }
            for (int j = 0; j < palabra.length(); j++) {
                matriz[filaRandom][columnaRandom + j] = palabra.substring(j, (j + 1));
            }
        }
        rellenarVacios(matriz);
        mostrarMatriz(matriz);
    }

    /*compruebo si hay lugar para no pisar otra palabra ya que puede estar en la misma fila (Si quisiera una 
     palabra por fila directamente recorrería la fila entera y no desde la posición de la columna) */
    public static boolean comprobarLugar(String[][] matriz, int fila, int columna, String palabra) {
        for (int j = 0; j < palabra.length(); j++) {
            if (matriz[fila][columna + j] != null) {
                return false;
            }
        }
        return true;
    }
    
    public static void rellenarVacios(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == null) {
                    matriz[i][j] = String.valueOf((int) (Math.random() * 10));
                }
            }
        }
    }   

    public static void mostrarMatriz(String[][] matriz) {
        for (String[] fila : matriz) {
            for (String elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println("");
        }
    }

}
