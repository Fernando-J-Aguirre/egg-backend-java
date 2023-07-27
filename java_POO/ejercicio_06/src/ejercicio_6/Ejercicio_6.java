
package ejercicio_6;

import entities.Cafetera;

public class Ejercicio_6 {

    public static void main(String[] args) {
        
        Cafetera cafetera = new Cafetera(500, 200);

        System.out.println("Cafetera inicial: " + cafetera);

        cafetera.llenarCafetera();
        System.out.println("Cafetera llena: " + cafetera);

        cafetera.servirTaza(100);

        cafetera.agregarCafe(50);

        System.out.println("Cafetera después de servir y agregar café: " + cafetera);

        cafetera.vaciarCafetera();
        System.out.println("Cafetera vacía: " + cafetera);
    }

}
