package services;

import entities.Pelicula;
import java.util.Scanner;

public class PeliculaService {
    
    private Scanner sc;
    
    public PeliculaService() {
        sc = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Pelicula crearPelicula() {
        Pelicula pelicula = new Pelicula();
        System.out.println("Ingrese título de la película");
        pelicula.setTitulo(sc.next());
        System.out.println("Ingrese duración de la película (total en minutos)");
        pelicula.setDuracion(sc.nextInt());
        System.out.println("Ingrese edad mínima habilitada para mirar la película");
        pelicula.setEdadMinima(sc.nextInt());
        System.out.println("Ingrese director de la película");
        pelicula.setTitulo(sc.next());
        return pelicula;
    }
}
