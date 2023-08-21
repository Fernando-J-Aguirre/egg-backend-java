package services;

import entities.Juego;
import entities.Jugador;
import entities.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoService {

    private final ArrayList<Jugador> jugadores;
    private final RevolverService revolverService;
    private final RevolverDeAgua revAgua;
    private final JugadorService jugadorService;
    private final Scanner sc;

    public JuegoService(RevolverService revolverService, JugadorService jugadorService) {
        jugadores = new ArrayList<>();
        this.revolverService = revolverService;
        revAgua = new RevolverDeAgua();
        this.jugadorService = jugadorService;
        sc = new Scanner(System.in).useDelimiter("\n");
    }

    private void crearJuego() {
        int cantidadJugadores;
        do {
            System.out.println("Ingrese cantidad de jugadores -- (mínimo 2 - máximo 6)");
            cantidadJugadores = sc.nextInt();
        } while (cantidadJugadores < 2);
        if (cantidadJugadores > 6) {
            cantidadJugadores = 6;
        }
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = jugadorService.crearJugador();
            jugador.setId(i + 1);
            jugadores.add(jugador);
        }
        revolverService.llenarRevolver();
    }

    private void llenarJuego(ArrayList<Jugador> players, RevolverDeAgua revolverDeAgua) {
        Juego juego = new Juego(jugadores, revolverDeAgua);
    }

    private void ronda() {
        boolean fin = false;
        do {
            for (Jugador jugador : jugadores) {
                System.out.println(revolverService.getString());
                System.out.println("Es el turno del jugador: " + jugador.getNombre());
                if (jugadorService.disparo(jugador)) {
                    System.out.println("MOJADO Jugador: " + jugador.getNombre() + " ID: " + jugador.getId());
                    System.out.println(revolverService.getString());
                    fin = true;
                    break;
                } else {
                    System.out.println("Sin mojar, continúa la ronda");
                    System.out.println();
                }
            }
        } while (!fin);
    }
     
    public void jugar() {
        System.out.println("Creando ruleta rusa de agua...");
        System.out.println();
        crearJuego();
        llenarJuego(jugadores, revAgua);
        System.out.println("Comencemos a jugar");
        System.out.println();
        ronda();
    }

}
