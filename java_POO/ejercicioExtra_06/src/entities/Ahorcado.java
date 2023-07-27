package entities;

import java.util.ArrayList;
import java.util.List;

public class Ahorcado {

    private List<String> palabra;
    private int letrasEncontradas;
    private int cantidadJugadasMax;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, int letrasEncontradas, int cantidadJugadasMax) {
        this.palabra = new ArrayList<>();
        this.letrasEncontradas = letrasEncontradas;
        this.cantidadJugadasMax = cantidadJugadasMax;
    }

    public List<String> getPalabra() {
        return palabra;
    }

    public void setPalabra(List<String> nuevaPalabra) {
        this.palabra = nuevaPalabra;
    }

    public int getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(int letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }

    public int getCantidadJugadasMax() {
        return cantidadJugadasMax;
    }

    public void setCantidadJugadasMax(int cantidadJugadasMax) {
        this.cantidadJugadasMax = cantidadJugadasMax;
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "palabra=" + palabra + ", letrasEncontradas=" + letrasEncontradas + ", cantidadJugadasMax=" + cantidadJugadasMax + '}';
    }

}
