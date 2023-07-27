package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio3 {

    /*Elaborar un algoritmo en el cuál se ingrese una letra y se detecte si se trata de una vocal.
Caso contrario mostrar un mensaje. Nota: investigar la función equals() de la clase String.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una letra para verificar si es una vocal");
        String letra = leer.nextLine();
        boolean verif = esVocal(letra);
        if (verif) {
            System.out.println("La letra - " + letra + " - es una vocal");
        } else {
            System.out.println("La letra - " + letra + " - no es una vocal");
        }

    }

    public static boolean esVocal(String letra) {
        String[] vocales = {"a", "e", "i", "o", "u"};
        for (int i = 0; i < vocales.length; i++) {
            if (letra.toLowerCase().equals(vocales[i])) {
                return true;
            }
        }
        return false;

// OPCION 2
//        String vocales = "aeiou";
//        return vocales.contains(letra.toLowerCase());
//    }
    }
}
