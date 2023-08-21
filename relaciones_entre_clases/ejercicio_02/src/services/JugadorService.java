package services;

import entities.Jugador;
import java.util.Scanner;

public class JugadorService {

    private final Scanner sc;
    private final RevolverService revolverService;
    
    public JugadorService(RevolverService revolverService) {
        sc = new Scanner(System.in).useDelimiter("\n");
        this.revolverService = revolverService;
    }
    
    public Jugador crearJugador() {
        Jugador jugador = new Jugador();
        System.out.println("Ingrese nombre del jugador");
        jugador.setNombre(sc.next());
        jugador.setMojado(false);
        return jugador;
    }
    
    public boolean disparo(Jugador jugador) {
        if(revolverService.mojar()) {
            jugador.setMojado(true);
            return true;
        }
        revolverService.siguienteChorro();
        return false;
    }
    
}
