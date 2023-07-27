package services;

import entities.Cadena;
import java.util.Scanner;

public class CadenaServicio {

    Cadena frase = new Cadena();
    Scanner scanner = new Scanner(System.in);

    public Cadena ingresarFrase() {
        System.out.println("Ingrese una palabra o frase separada por espacios");
        frase.setFrase(scanner.nextLine());
        frase.setLongitud(frase.getLongitud());
        return frase;
    }

    public int contarVocales() {
        int contador = 0;
        String vocales = "aeiou";
        for (int i = 0; i < frase.getLongitud(); i++) {
            char c = frase.getFrase().toLowerCase().charAt(i);
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    // Opción 1
//    public String invertirFrase() {
//        String cadena = frase.getFrase();
//        String invertida = "";
//        for (int i = cadena.length() - 1; i >= 0; i--) {
//            invertida += cadena.charAt(i);
//        }        
//        return invertida;
//    }
    // Opción 2
    public String invertirFrase() {
        String cadena = frase.getFrase();
        StringBuilder invertida = new StringBuilder(cadena);
        invertida.reverse();
        return invertida.toString();
    }

    public void vecesRepetido(char c) {
        int contador = 0;
        String cadena = frase.getFrase();
        for (int i = 0; i < frase.getLongitud(); i++) {
            if (cadena.toLowerCase().charAt(i) == c) {
                contador++;
            }
        }
        System.out.println("El caracter " + c + " se repite: " + contador + " veces");
    }

    public void compararLongitud(String cadena) {
        System.out.println("La longitud de la frase original es: " + frase.getLongitud());
        System.out.println("La longitud de la frase ingresada es: " + cadena.length());
    }

    public String unirFrases(String cadena) {
        return frase.getFrase().concat(cadena);
    }

    public void reemplazar(char letra) {
        String cadena = frase.getFrase();
        cadena = cadena.replace('a', letra);
        System.out.println("Frase resultante: " + cadena);
    }
    
    public boolean contiene(String letra) {
        String cadena = frase.getFrase();
        return cadena.contains(letra);
    }

    public String mostrar() {
        return frase.toString();
    }
}
