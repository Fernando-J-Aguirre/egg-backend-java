/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public final class EdificioDeOficinas extends Edificio {

    private int numeroOficinas;
    private int cantidadPersonasOficina;
    private int cantidadPisos;

    public EdificioDeOficinas(int numeroOficinas, int cantidadPersonasOficina, int cantidadPisos, double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.cantidadPersonasOficina = cantidadPersonasOficina;
        this.cantidadPisos = cantidadPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    public int getCantidadPersonasOficina() {
        return cantidadPersonasOficina;
    }

    public void setCantidadPersonasOficina(int cantidadPersonasOficina) {
        this.cantidadPersonasOficina = cantidadPersonasOficina;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }
    
    public void cantPersonas(){
        
        System.out.println("Personas por piso: " + getCantidadPersonasOficina()*getNumeroOficinas());        
        System.out.println("Persnas en tdo el edificio: "+getCantidadPersonasOficina()*getNumeroOficinas()*getCantidadPisos());    
        
    }
    
    @Override
    public void calcularSuperficie() {
        System.out.println("Superficie del edificio de oficinas: "+ getAncho()*getLargo());
    }

    @Override
    public void calcularVolumen() {
        System.out.println("Volumen del edificio de oficinas: "+ getAncho()*getLargo()*getAlto());
    }
    
    
    
}
