package services;

import entities.Pelicula;
import java.util.Scanner;

public class PeliculaService {

    Pelicula[] peliculas = new Pelicula[5];
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Pelicula crearPelicula() {
        Pelicula peli = new Pelicula();
        System.out.println("Ingrese titulo de la pelicula");
        peli.setTitulo(scanner.next());
        System.out.println("Ingrese género de la pelicula");
        peli.setGenero(scanner.next());
        System.out.println("Ingrese año de la pelicula");
        peli.setAño(scanner.nextInt());
        System.out.println("Ingrese duración de la pelicula");
        peli.setDuración(scanner.nextInt());
        return peli;
    }

    public void cargarPelicula() {
        boolean hayLugar = false;
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = crearPelicula();
                System.out.println("La pelicula se ha cargado en la posición " + i);
                hayLugar = true;
                break;
            }
        }
        if (!hayLugar) {
            System.out.println("No hay más lugar para cargar películas");
        }
    }

    public void listarPeliculas() {
        System.out.println("Todas las películas");
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] != null) {
                System.out.println(peliculas[i].toString());
            }
        }
    }

    public void listarDisponibles() {
        System.out.println("Películas disponibles");
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] != null && peliculas[i].isDisponible()) {
                System.out.println(peliculas[i].toString());
            }
        }
    }

    public Pelicula buscarPorTitulo() {
        System.out.println("Ingrese el título de la película a buscar");
        String title = scanner.next();
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] != null && peliculas[i].getTitulo().equalsIgnoreCase(title)) {
                System.out.println(peliculas[i].toString());
                return peliculas[i];
            }
        }
        return null;
    }

    public void buscarPorGenero() {
        boolean existe = false;
        System.out.println("Ingrese el género de la película a buscar");
        String genre = scanner.next();
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] != null && peliculas[i].getGenero().equalsIgnoreCase(genre)) {
                System.out.println("Sí existe");
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("No existe película con ese género");
        }
    }

    public void eliminarPelicula() {
        System.out.println("Ingrese el título de la película que quiere eliminar");
        String title = scanner.next();
        for (int i = 0; i < 5; i++) {
            if (peliculas[i] != null && peliculas[i].getTitulo().equalsIgnoreCase(title)) {
                peliculas[i] = null;
                reordenarArray(i);
                System.out.println("La película se ha eliminado de la lista");
                return;
            }
        }
        System.out.println("No existe película con ese título");
    }

    public void reordenarArray(int pos) {
        for (int i = pos; i < 4; i++) {
            if (peliculas[i] == null && peliculas[i + 1] != null) {
                peliculas[i] = peliculas[i + 1];
                peliculas[i + 1] = null;
            }
        }
    }

}
