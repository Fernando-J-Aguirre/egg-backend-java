package ejercicio_02;

import Entidades.Electrodomestico;
import Entidades.Lavarropas;
import Entidades.Televisor;
import java.util.ArrayList;

public class Ejercicio_02 {

    public static void main(String[] args) {
//        Lavarropas lavarropas = new Lavarropas();
//        lavarropas.crearLavarropas();
//        System.out.println(lavarropas);
//
//        Televisor tele = new Televisor();
//        tele.crearTelevisor();
//        System.out.println(tele);

// PUNTO 3
//        Lavarropas lav1 = new Lavarropas(40, 5000, "Rojo", 'B', 50);
//        Lavarropas lav2 = new Lavarropas(50, 2000, "Negro", 'D', 78);
//
//        Televisor tv1 = new Televisor(65, true, 10000, "Azul", 'A', 45);
//        Televisor tv2 = new Televisor(42, false, 5000, "Verde", 'Y', 30);
//
//        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
//
//        electrodomesticos.add(lav1);
//        electrodomesticos.add(lav2);
//        electrodomesticos.add(tv1);
//        electrodomesticos.add(tv2);
//
//        Integer precioLavarropas = 0;
//        Integer precioTvs = 0;
//
//        for (Electrodomestico electrodomestico : electrodomesticos) {
//            electrodomestico.precioFinal();
//            if (electrodomestico instanceof Lavarropas) {
//                precioLavarropas += electrodomestico.getPrecio();
//            } else {
//                precioTvs += electrodomestico.getPrecio();
//            }
//        }
        
        //OPCION 2
        
        Electrodomestico lav1 = new Lavarropas(40, 5000, "Rojo", 'B', 50);
        Electrodomestico lav2 = new Lavarropas(50, 2000, "Negro", 'D', 78);

        Electrodomestico tv1 = new Televisor(65, true, 10000, "Azul", 'A', 45);
        Electrodomestico tv2 = new Televisor(42, false, 5000, "Verde", 'Y', 30);

        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

        electrodomesticos.add(lav1);
        electrodomesticos.add(lav2);
        electrodomesticos.add(tv1);
        electrodomesticos.add(tv2);

        Integer precioLavarropas = 0;
        Integer precioTvs = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavarropas) {
                ((Lavarropas) electrodomestico).precioFinal();
                precioLavarropas += electrodomestico.getPrecio();
            } else {
                precioTvs += electrodomestico.getPrecio();
            }
        }

        System.out.println("El precio de todos los lavarropas es = $" + precioLavarropas);
        System.out.println("El precio de todos los televisores es = $" + precioTvs);
        System.out.println("El precio de todos los electrodomésticos es = $" + (precioLavarropas + precioTvs));
    }
    
    

}
