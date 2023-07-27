package ejercicios6a9;

import java.util.Scanner;

public class Ejercicio8 {

    /*Realizar un programa que solo permita introducir solo frases o palabras de 8 de largo. Si el
usuario ingresa una frase o palabra de 8 de largo se deberá de imprimir un mensaje por
pantalla que diga “CORRECTO”, en caso contrario, se deberá imprimir “INCORRECTO”.
Nota: investigar la función Lenght() en Java.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean longit = false;

        do {
            System.out.println("Ingrese palabra o frase de 8 de longitud");
            String frase = leer.nextLine();
            if (frase.length() == 8) longit = true;
        } while (!longit);
        
        if(longit) System.out.println("CORRECTO");
    }

}
