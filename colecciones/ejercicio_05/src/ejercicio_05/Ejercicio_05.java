package ejercicio_05;

import services.PaisService;

public class Ejercicio_05 {

    public static void main(String[] args) {
        
        PaisService ps = new PaisService();

        ps.guardarPaises();
        System.out.println();

        ps.mostrarPaises();
        System.out.println();

        ps.ordenarPaisesAsc();
        System.out.println();

        ps.mostrarPaises();
        System.out.println();

        ps.eliminarPais();
        System.out.println();

        ps.mostrarPaises();
        System.out.println();

    }

}
