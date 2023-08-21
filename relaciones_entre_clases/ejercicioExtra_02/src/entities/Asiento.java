package entities;

public class Asiento {

    private LetraAsiento letra;
    private int numero;
    private boolean ocupado;
    private Espectador espectador;

    public Asiento() {
    }

    public Asiento(LetraAsiento letra, int numero, boolean ocupado) {
        this.letra = letra;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public LetraAsiento getLetra() {
        return letra;
    }

    public void setLetra(LetraAsiento letra) {
        this.letra = letra;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
        
    @Override
    public String toString() {
        return numero + " " + letra + (isOcupado() ? " X" : " ");
    }
    
}
