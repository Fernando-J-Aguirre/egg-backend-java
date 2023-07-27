package ejercicio_9;

import services.MatematicaServicio;

public class Ejercicio_9 {

    public static void main(String[] args) {

        MatematicaServicio ms = new MatematicaServicio();

        ms.llenarNumeros();
        System.out.println(ms.mostrar());
        ms.devolverMayor();
        System.out.println();
        ms.calcularPotencia();
        System.out.println();
        ms.calcularRaiz();

    }

}
