
package services;

import biblioteca.Libro;
import java.util.Scanner;

public class LibroServicio {
    
    public Libro crearLibro() {
        Libro libro1 = new Libro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese autor");
        libro1.setAutor(scanner.nextLine());
        System.out.println("Ingrese título");
        libro1.setTitulo(scanner.nextLine());
        System.out.println("Ingrese ISBN");
        libro1.setIsbn(scanner.nextLine());
        System.out.println("Ingrese cantidad de páginas");
        libro1.setCantPags(scanner.nextInt());
        return libro1;        
    }
    
        
}
