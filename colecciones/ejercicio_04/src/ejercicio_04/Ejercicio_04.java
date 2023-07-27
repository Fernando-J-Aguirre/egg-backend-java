
package ejercicio_04;

import services.PeliculaService;

public class Ejercicio_04 {

    public static void main(String[] args) {
        PeliculaService ps = new PeliculaService();
        ps.crearPelicula();
        System.out.println("TODAS LAS PELICULAS DESORDENADAS");
        ps.mostrarPeliculas();
        System.out.println("");
        System.out.println("MAYOR A UNA HORA");
        ps.motrarMayorAUnaHora();
        System.out.println("");
        System.out.println("MAYOR A MENOR DURACION");
        ps.ordenarDuracionMayorAMenor();
        System.out.println("");
        System.out.println("MENOR A MAYOR DURACION");
        ps.ordenarDuracionMenorAMayor();
        System.out.println("");
        System.out.println("POR TITULO");
        ps.ordenarPorTitulo();
        System.out.println("");
        System.out.println("POR DIRECTOR");
        ps.ordernarPorDirector();
    }

}
