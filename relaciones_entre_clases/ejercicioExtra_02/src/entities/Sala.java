
package entities;

import java.util.ArrayList;

public class Sala {
    
    private ArrayList<ArrayList<Asiento>> asientos = new ArrayList<>();
    private ArrayList<Espectador> espectadores = new ArrayList<>();
    private int cantidadDisponibles;

    public Sala() {
    }

    public ArrayList<ArrayList<Asiento>> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<ArrayList<Asiento>> asientos) {
        this.asientos = asientos;
    }

    public ArrayList<Espectador> getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(ArrayList<Espectador> espectadores) {
        this.espectadores = espectadores;
    }

    public int getCantidadDisponibles() {
        return cantidadDisponibles;
    }

    public void setCantidadDisponibles(int cantidadDisponibles) {
        this.cantidadDisponibles = cantidadDisponibles;
    }

    @Override
    public String toString() {
        return "Sala{" + "asientos=" + asientos + ", espectadores=" + espectadores + ", cantidadDisponibles=" + cantidadDisponibles + '}';
    }
    
    
    
    

}
