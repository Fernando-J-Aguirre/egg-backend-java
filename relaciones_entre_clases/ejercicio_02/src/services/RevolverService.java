package services;

import entities.RevolverDeAgua;

public class RevolverService {

    private final RevolverDeAgua rev;

    public RevolverService() {
        rev = new RevolverDeAgua();
    }
    
    public void llenarRevolver() {
        rev.setPosicionActual((int) ((Math.random() * 6) + 1));
        rev.setPosicionAgua((int) ((Math.random() * 6) + 1));
    }

    public boolean mojar() {
        return rev.getPosicionAgua() == rev.getPosicionActual();
    }
    
    public void siguienteChorro() {
        if(rev.getPosicionActual() == 6) {
            rev.setPosicionActual(1);
        } else {
            rev.setPosicionActual(rev.getPosicionActual() + 1);
        }
    }
    
    public String getString() {
        return "Posición actual = " + rev.getPosicionActual() + "\nPosición de agua = " + rev.getPosicionAgua();
    }

}
