package services;

import entities.Alquiler;
import entities.Pelicula;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AlquilerService {

    Alquiler alquileres[] = new Alquiler[3];
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private PeliculaService ps;

    public AlquilerService(PeliculaService peliculaService) {
        this.ps = peliculaService;
    }

    public Alquiler crearAlquiler() {
        System.out.println("ALQUILER");
        Pelicula pelicula = ps.buscarPorTitulo();
        if (pelicula != null && pelicula.isDisponible()) {
            System.out.println("La pelicula se encuentra disponible");
            Alquiler alquiler = new Alquiler();
            alquiler.setPeliculaAlquilada(pelicula);
            pelicula.setDisponible(false);
            System.out.println("Ingrese fecha inicio de alquiler en formato: yyyy-mm-dd");
            LocalDate fechaInicio = LocalDate.parse(scanner.next());
            alquiler.setFechaInicio(fechaInicio);
            System.out.println("La fecha alquilada es " + fechaInicio);
            System.out.println("Ingrese fecha fin de alquiler en formato: yyyy-mm-dd");
            LocalDate fechaFin = LocalDate.parse(scanner.next());
            alquiler.setFechaFin(fechaFin);
            System.out.println("La fecha de devolución es " + fechaFin);
            double precio = calcularIngreso(alquiler);
            alquiler.setPrecio(precio);            
            return alquiler;
        } else {
            System.out.println("No se encontró una película con ese título");
            return null;
        }
    }

    public void cargarAlquiler() {
        Alquiler alquiler = crearAlquiler();
        if (alquiler != null) {
            for (int i = 0; i < 3; i++) {
                if (alquileres[i] == null) {
                    alquileres[i] = alquiler;
                    System.out.println("El alquiler se ha creado exitosamente.");
                    return;
                }
            }
        } else {
            System.out.println("No se pudo cargar el alquiler");
            return;
        }
        System.out.println("No hay más lugar para cargar películas");
    }

    public void listarAlquileres() {
        System.out.println("Peliculas alquiladas");
        for (int i = 0; i < 3; i++) {
            if (alquileres[i] != null) {
                System.out.println("Título = " + alquileres[i].getPeliculaAlquilada().getTitulo());
                System.out.println("Datos del alquiler");
                System.out.println(alquileres[i].toString());
            }
        }
    }

    public void buscarPorFecha() {
        System.out.println("Ingrese una fecha para verificar si existe ese alquiler");
        LocalDate fecha = LocalDate.parse(scanner.next());
        for (int i = 0; i < 3; i++) {
            if (alquileres[i] != null && alquileres[i].getFechaInicio().compareTo(fecha) <= 0 && alquileres[i].getFechaFin().compareTo(fecha) >= 0) {
                System.out.println("La pelicula se encuentra alquilada");
                return;
            }
        }
        System.out.println("La pelicula NO se encuentra alquilada");
    }

    public double calcularIngreso(Alquiler alquiler) {
        double ingreso = 10;
        int cantDias = calcularDias(alquiler);
        if (cantDias > 3) {
            int diasDeMas = cantDias - 3;
            ingreso += (diasDeMas * ingreso) * 0.1;
        }
        return ingreso;
    }
    
    private int calcularDias(Alquiler alq) {
        Period period = Period.between(alq.getFechaInicio(), alq.getFechaFin());
        System.out.println("Cantidad de días " + period.getDays());
        return period.getDays();
    }

}
