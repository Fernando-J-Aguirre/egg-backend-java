/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioExtra_02;

import Entidades.Edificio;
import Entidades.EdificioDeOficinas;
import Entidades.Polideportivo;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class EjercicioExtra_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Edificio> edificios = new ArrayList();
        
        Polideportivo p1 = new Polideportivo("Poli1", "Techado", 10, 7, 10);
        Polideportivo p2 = new Polideportivo("Poli2", "Abierto", 4, 3, 5);
        EdificioDeOficinas o1 = new EdificioDeOficinas(4, 2, 5, 10, 7, 10);
        EdificioDeOficinas o2 = new EdificioDeOficinas(3, 1, 12, 4, 3, 4);
        
        edificios.add(p1);
        edificios.add(p2);
        edificios.add(o1);
        edificios.add(o2);
        
        for (Edificio edificio : edificios) {
            
            edificio.calcularSuperficie();
            edificio.calcularVolumen();
            
            if (edificio instanceof Polideportivo) {
                System.out.println("El polideportivo es: " + ((Polideportivo) edificio).getTipoInstalacion());
            }
            if (edificio instanceof EdificioDeOficinas) {
                ((EdificioDeOficinas) edificio).cantPersonas();
            }
            
            System.out.println("----------------");
        }
        
    }
    
}
