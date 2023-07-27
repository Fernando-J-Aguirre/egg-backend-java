
package ejercicio2;

import entities.Circunferencia;
import services.CircunferenciaServicio;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        CircunferenciaServicio cs = new CircunferenciaServicio();
        Circunferencia circ = cs.crearCircunferencia();
        cs.area(circ);
        cs.perimetro(circ);
    }

}
