package services;

import entities.Libro;
import entities.Usuario;
import java.util.HashSet;
import java.util.Scanner;

public class LibroService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private HashSet<Libro> libros = new HashSet<>();
    private HashSet<Usuario> usuarios = new HashSet<>();

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

    private void agregarUsuarios() {
        UsuarioService us = new UsuarioService();
        usuarios.add(us.crearUsuario());
    }

    private void mostrar() {
        libros.forEach(e -> System.out.println(e));
    }

    private String solicitarTituloLibro() {
        System.out.println("Ingrese el título del libro");
        return sc.next();
    }

    private void eliminarLibro() {
        String titulo = solicitarTituloLibro();
        boolean eliminado = libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
        if (eliminado) {
            System.out.println("Libro eliminado exitosamente");
        } else {
            System.out.println("No se encuentra libro con ese título");
        }
    }

    private void buscarLibroPorTitulo() {
        String titulo = solicitarTituloLibro();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Se encontró el libro: " + libro);
                return;
            }
        }
        System.out.println("No se encuentra libro con ese título");
    }

    private void buscarLibroEnUsuario(String titulo, String nombre) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.prestamo()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("El usuario tiene los siguientes libros: " + usuario.getLibros());
                        return;
                    }
                }
            }
        }
        System.out.println("El usuario no tiene ese libro o no tiene libros en su poder");
    }

    private void prestarLibro() {
        String titulo = solicitarTituloLibro();
        System.out.println("Ingrese el nombre del usuario que requiere el libro");
        String nombre = sc.next();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.prestamo()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                        usuario.getLibros().add(libro);
                        System.out.println("Préstamo exitoso al usuario: " + usuario.getNombre());
                        return;
                    }
                }
            }
        }
        System.out.println("No hay más ejemplares disponibles");
    }

    private void devolverLibro() {
        String titulo = solicitarTituloLibro();
        System.out.println("Ingrese el nombre del usuario que requiere el libro");
        String nombre = sc.next();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.devolucion()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                        usuario.getLibros().remove(libro);
                        System.out.println("Devolución exitosa del usuario: " + usuario.getNombre());
                        return;
                    }
                }
            }
        }
        System.out.println("Error. Ejemplares completos");
    }

    private void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre = " + usuario.getNombre());
            System.out.println("Libros prestados:");
            usuario.getLibros().forEach(libro -> System.out.println(libro));
        }
    }

    private void buscarUsuario() {
        System.out.println("Ingrese el nombre del usuario");
        String nombre = sc.next();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Usuario encontrado");
                System.out.println(usuario);
                return;
            }
        }
        System.out.println("No se encuentra el usuario");
    }

    public void mostrarMenu() {
        System.out.println("Ingrese una opción del menú");
        int opcion = 0;
        while (opcion != 10) {
            System.out.println("MENU");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Préstamo");
            System.out.println("4. Devolución");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Eliminar libro");
            System.out.println("7. Agregar usuario");
            System.out.println("8. Mostrar usuarios");
            System.out.println("9. Buscar usuario por nombre");
            System.out.println("10. Buscar un libro en un usuario específico");
            System.out.println("11. Salir");
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
                buscarLibroPorTitulo();
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
                agregarUsuarios();
                break;
            case 8:
                mostrarUsuarios();
                break;
            case 9:
                buscarUsuario();
                break;
            case 10:
                String titulo = solicitarTituloLibro();
                System.out.println("Ingrese nombre de usuario");
                String nombre = sc.next();
                buscarLibroEnUsuario(titulo, nombre);
                break;
            case 11:
                System.out.println("Saliendo..");
                break;
            default:
                System.out.println("Opción inválida, intente nuevamente");
        }
    }

}
