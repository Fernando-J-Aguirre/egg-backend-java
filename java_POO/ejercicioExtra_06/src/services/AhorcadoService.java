package services;

import entities.Ahorcado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AhorcadoService {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    Ahorcado ahorcado = new Ahorcado();
    private List<String> aux;

    public void crearJuego() {
        System.out.println("Ingrese la palabra a adivinar");
        String palabra = scanner.next();
        cargarPalabra(palabra);
        System.out.println("Ingrese cantidad de jugadas máxima");
        ahorcado.setCantidadJugadasMax(scanner.nextInt());
        ahorcado.setLetrasEncontradas(0);
    }

    private void cargarPalabra(String palabra) {
        List<String> array = new ArrayList<>();
        aux = new ArrayList<>();
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            aux.add(" _ ");
            array.add(String.valueOf(c));
        }
        ahorcado.setPalabra(array);
    }

    public int longitud() {
        return ahorcado.getPalabra().size();
    }

    public void dibujar(List<String> array) {
        array.forEach(element -> System.out.print(element));
    }

    public void rellenarAhorcado(String letra) {
        for (int i = 0; i < longitud(); i++) {
            if (ahorcado.getPalabra().get(i).equals(letra)) {
                aux.set(i, " " + letra.toUpperCase() + " ");
            }
        }
    }

    public void buscar(String letra) {
        if (ahorcado.getPalabra().contains(letra)) {
            System.out.println("La letra pertenece a la palabra");
        } else {
            System.out.println("La letra no pertenece a la palabra");
        }
    }

    public boolean encontradas(String letra) {
        int contador = 0;
        int encont = ahorcado.getLetrasEncontradas();
        for (int i = 0; i < longitud(); i++) {
            if (ahorcado.getPalabra().get(i).equals(letra)) {
                contador++;
            }
        }
        encont += contador;
        ahorcado.setLetrasEncontradas(encont);
        int faltantes = longitud() - encont;
        System.out.println("Número de letras (encontradas, faltantes): (" + encont + "," + faltantes + ")");
        return contador > 0;
    }

    public void juego() {
        crearJuego();
        System.out.println();
        System.out.println("La palabra tiene: " + longitud() + " letras");
        int intentos = ahorcado.getCantidadJugadasMax();
        boolean adivino = false;
        do {
            dibujar(aux);
            System.out.println();
            System.out.println();
            System.out.println("Ingrese una letra:");
            String letra = scanner.next();
            buscar(letra);
            rellenarAhorcado(letra);
            System.out.println();
            boolean encont = encontradas(letra);
            if (!encont) {
                intentos--;
            }
            System.out.println("Número de oportunidades restantes: " + intentos);
            if (ahorcado.getLetrasEncontradas() == longitud() && intentos > 0) {
                System.out.println();
                dibujar(aux);
                System.out.println();
                System.out.println("Felicidades, adivinó");
                adivino = true;
            }
            System.out.println();
            System.out.println("**********************************");
            System.out.println();
        } while (intentos > 0 && !adivino);

        if (!adivino) {
            System.out.println("Lo sentimos, no hay más oportunidades");
        }

    }

}
