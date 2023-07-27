package entities;


public class Vehiculo {
    
    private String marca;
    private String modelo;
    private int anio;
    private String tipo;
    private int metrosR;

    public int getMetrosR() {
        return metrosR;
    }

    public void setMetrosR(int metrosR) {
        this.metrosR = metrosR;
    }

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, String tipo, int metrosR) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.metrosR = metrosR;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", tipo=" + tipo + '}';
    }
    
    
}
