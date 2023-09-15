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
public final class Polideportivo extends Edificio{

    private String nombre;
    private String tipoInstalacion;

    public Polideportivo(String nombre, String tipoInstalacion, double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }
    
    
    
    @Override
    public void calcularSuperficie() {
        
        System.out.println("Superficie del polideportivo: "+ getAncho()*getLargo());
        
    }

    @Override
    public void calcularVolumen() {
        
        System.out.println("Volumen del polideportivo: "+ getAncho()*getLargo()*getAlto());
        
    }
    
    
    
}
