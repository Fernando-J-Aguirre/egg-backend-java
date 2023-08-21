package entities;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private RevolverDeAgua revolverDeAgua;

    public Juego() {
    }

    public Juego(ArrayList<Jugador> jugadores, RevolverDeAgua revolverDeAgua) {
        this.jugadores = jugadores;
        this.revolverDeAgua = revolverDeAgua;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverDeAgua getRevolverDeAgua() {
        return revolverDeAgua;
    }

    public void setRevolverDeAgua(RevolverDeAgua revolverDeAgua) {
        this.revolverDeAgua = revolverDeAgua;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugadores=" + jugadores + ", revolverDeAgua=" + revolverDeAgua + '}';
    }

}
