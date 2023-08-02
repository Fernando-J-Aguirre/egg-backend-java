package services;

import entities.Libro;
import java.util.HashSet;
import java.util.Scanner;

public class LibroService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private HashSet<Libro> libros = new HashSet<>();

    private void insertarLibro() {
        Libro libro = new Libro();
        System.out.println("Ingrese el título");
        libro.setTitulo(sc.next());
        System.out.println("Ingrese el autor");
        libro.setAutor(sc.next());
        System.out.println("Ingrese cantidad de ejemplares existentes");
        libro.setTotalEjemplares(sc.nextInt());
        libro.setEjemplaresPrestados(0);
        libros.add(libro);
    }

    private void mostrar() {
        libros.forEach(e -> System.out.println(e));
    }

    private void eliminarLibro() {
        System.out.println("Ingrese el título del libro a eliminar");
        String titulo = sc.next();
        boolean eliminado = libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
        if (eliminado) {
            System.out.println("Libro eliminado exitosamente");
        } else {
            System.out.println("No se encuentra libro con ese título");
        }
    }

    private void buscarLibro() {
        System.out.println("Ingrese el título del libro a buscar");
        String titulo = sc.next();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                System.out.println("Se encontró el libro: " + libro);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encuentra libro con ese título");
        }
    }

    private void prestarLibro() {
        System.out.println("Ingrese el título del libro que requiere");
        String titulo = sc.next();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.prestamo()) {
                encontrado = true;
                System.out.println("Préstamo exitoso");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No hay más ejemplares disponibles");
        }
    }

    private void devolverLibro() {
        System.out.println("Ingrese el título del libro que devuelve");
        String titulo = sc.next();
        boolean devuelto = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.devolucion()) {
                devuelto = true;
                System.out.println("Devolución exitosa");
                break;
            }
        }
        if (!devuelto) {
            System.out.println("Error. Ejemplares completos");
        }
    }

    public void mostrarMenu() {
        System.out.println("Ingrese una opción del menú");
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("MENU");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Préstamo");
            System.out.println("4. Devolución");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Eliminar libro");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            menu(opcion);
        }
    }

    private void menu(int opcion) {
        switch (opcion) {
            case 1:
                insertarLibro();
                break;
            case 2:
                buscarLibro();
                break;
            case 3:
                prestarLibro();
                break;
            case 4:
                devolverLibro();
                break;
            case 5:
                mostrar();
                break;
            case 6:
                eliminarLibro();
                break;
            case 7:
                System.out.println("Saliendo..");
                break;
            default:
                System.out.println("Opción inválida, intente nuevamente");
        }
    }

}
