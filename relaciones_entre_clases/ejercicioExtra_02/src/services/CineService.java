package services;

import entities.Asiento;
import entities.Cine;
import entities.Espectador;
import entities.LetraAsiento;
import entities.Pelicula;
import entities.Sala;
import java.util.ArrayList;
import java.util.Scanner;

public class CineService {

    private Scanner sc;
    private Asiento asiento;
    private Cine cine;
    private Sala sala;
    private SalaService ss;
    private Pelicula pelicula;

    public CineService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        asiento = new Asiento();
        cine = new Cine();
        sala = new Sala();
        ss = new SalaService();
        pelicula = new Pelicula();
    }

    public Cine crearCine() {
        sala = ss.crearSala();
        PeliculaService ps = new PeliculaService();
        pelicula = ps.crearPelicula();
        System.out.println("Ingrese el valor de la entrada");
        double precio = sc.nextDouble();
        cine.setPelicula(pelicula);
        cine.setPrecioEntrada(precio);
        cine.setSala(sala);
        return cine;
    }

    public void ubicarEspectador() {
        ArrayList<Espectador> espectadores = sala.getEspectadores();
        if (espectadores.isEmpty()) {
            System.out.println("No hay más espectadores para acomodar");
            return;
        }
        Espectador espectador = sala.getEspectadores().get(0);
        int fila = getRandomNumber(1, 7);
        LetraAsiento letra = LetraAsiento.values()[getRandomNumber(0, LetraAsiento.values().length)];
        if (verifDineroYEdadEspectador(espectador)) {
            if (ss.asientoDisponible(fila, letra, espectador)) {
                procesarUbicacion(espectador);
                System.out.println("Espectador -" + espectador.getNombre() + "- ubicado correctamente en la fila: " + fila + " - columna: " + letra);
            } else {
                reubicarEspectador(espectador);
            }
        } else {
            espectadores.remove(espectador);
            System.out.println("Error en la verificación del espectador: " + espectador.getNombre() + ". " + "No cumple los requisitos para entrar.");
        }
    }

    private void procesarUbicacion(Espectador espectador) {
        ArrayList<Espectador> espectadores = sala.getEspectadores();
        sala.setCantidadDisponibles(sala.getCantidadDisponibles() - 1);
        espectadores.remove(espectador);
        sala.setEspectadores(espectadores);
    }

    private void reubicarEspectador(Espectador espectador) {
        int fila;
        LetraAsiento letra;
        do {
            System.out.println("Asiento ocupado, se lo está reubicando..");
            fila = getRandomNumber(1, 7);
            letra = LetraAsiento.values()[getRandomNumber(0, LetraAsiento.values().length)];
        } while (!ss.asientoDisponible(fila, letra, espectador));
        
        procesarUbicacion(espectador);
        System.out.println("Espectador reubicado. fila: " + fila + " - columna: " + letra);

    }

    public void menu() {
        crearCine();
        int opcion;
        System.out.println("MENU");
        System.out.println("-------");
        do {
            System.out.println("1- Mostrar Sala y cantidad de asientos disponibles");
            System.out.println("2- Agregar uno o más espectadores");
            System.out.println("3- Ubicar espectador en la sala");
            System.out.println("4- Ver todos los espectadores ubicados en la sala");
            System.out.println("5- Buscar ubicación de espectador");
            System.out.println("6- Salir");
            opcion = sc.nextInt();
            opcionMenu(opcion);
        } while (opcion != 6);
    }

    private void opcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Asientos disponibles = " + sala.getCantidadDisponibles());
                ss.mostrarAsientos();
                System.out.println();
                break;
            case 2:
                System.out.println("Ingrese cantidad de espectadores que va a ingresar");
                int cantidad = sc.nextInt();
                ss.crearEspectadores(cantidad);
                System.out.println();
                break;
            case 3:
                ubicarEspectador();
                System.out.println();
                break;
            case 4:
                ss.verEspectadoresEnAsiento();
                System.out.println();
                break;
            case 5:
                ss.buscarUbicacionDeEspectador();
                System.out.println();
                break;
            case 6:
                System.out.println("Fin...");
                System.out.println();
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    }

    public boolean verifDineroYEdadEspectador(Espectador espectador) {
        return ((espectador.getDinero() >= cine.getPrecioEntrada()) && (espectador.getEdad() >= pelicula.getEdadMinima()));
    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

}
