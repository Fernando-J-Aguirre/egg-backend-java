package actividadgrupal2;

import java.util.Scanner;
import services.AlquilerService;
import services.PeliculaService;

public class ActividadGrupal2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PeliculaService ps = new PeliculaService();
        AlquilerService as = new AlquilerService(ps);

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú");
            System.out.println("1. Cargar una pelicula");
            System.out.println("2. Listar todas las peliculas");
            System.out.println("3. Listar peliculas disponibles");
            System.out.println("4. Cargar un alquiler");
            System.out.println("5. Lista de todos los alquileres");
            System.out.println("6. Buscar pelicula por título");
            System.out.println("7. Buscar pelicula por genero");
            System.out.println("8. Buscar alquileres por fecha");
            System.out.println("9. Eliminar pelicula");
            System.out.println("10. Salir");
            System.out.println("Ingrese una de las opciones: ");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    ps.cargarPelicula();
                    break;
                case 2:
                    ps.listarPeliculas();
                    break;
                case 3:
                    ps.listarDisponibles();
                    break;
                case 4:
                    as.cargarAlquiler();
                    break;
                case 5:
                    as.listarAlquileres();
                    break;
                case 6:
                    ps.buscarPorTitulo();
                    break;
                case 7:
                    ps.buscarPorGenero();
                    break;
                case 8:
                    as.buscarPorFecha();
                    break;
                case 9:
                    ps.eliminarPelicula();
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

}
