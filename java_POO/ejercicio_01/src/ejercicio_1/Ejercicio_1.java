package ejercicio_1;

import biblioteca.Libro;
import services.LibroServicio;

public class Ejercicio_1 {

    public static void main(String[] args) {
        
        LibroServicio ls = new LibroServicio();
        Libro libro1 = ls.crearLibro();
        System.out.println(libro1.toString());
        
    }

}
