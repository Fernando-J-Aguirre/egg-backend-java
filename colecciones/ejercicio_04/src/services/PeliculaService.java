package services;

import entities.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import utilities.Comparadores;

public class PeliculaService {

    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void crearPelicula() {
        String respuesta;
        do {
            Pelicula pelicula = new Pelicula();
            System.out.println("Ingrese titulo");
            pelicula.setTitulo(scanner.next());
            System.out.println("Ingrese director");
            pelicula.setDirector(scanner.next());
            System.out.println("Ingrese duracion");
            pelicula.setDuracion(scanner.nextInt());

            peliculas.add(pelicula);

            System.out.println("Quiere ingresar otra película? S/N");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("s"));
    }
    
    public void mostrarPeliculas() {
        peliculas.forEach((e) -> System.out.println(e));
    }
    
    public void motrarMayorAUnaHora() {
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getDuracion() > 1) {
                System.out.println(pelicula);
            }
        }
    }
    
    public void ordenarDuracionMayorAMenor() {
        Collections.sort(peliculas, Comparadores.ordenarMayorAMenorDuracion);
        mostrarPeliculas();
    }
    
    public void ordenarDuracionMenorAMayor() {
        Collections.sort(peliculas, Comparadores.ordenarMenorAMayorDuracion);
        mostrarPeliculas();
    }
    
    public void ordenarPorTitulo() {
        Collections.sort(peliculas, Comparadores.ordenarPorTitulo);
        mostrarPeliculas();
    }
    
    public void ordernarPorDirector() {
        Collections.sort(peliculas, Comparadores.ordenarPorDirector);
        mostrarPeliculas();
    }

}
