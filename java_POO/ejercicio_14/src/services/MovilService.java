
package services;

import entities.Movil;
import java.util.Scanner;

public class MovilService {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    Movil movil = new Movil();
    
    public Movil cargarCelular() {
        System.out.println("Ingrese marca del móvil");
        movil.setMarca(scanner.next());
        System.out.println("Ingrese precio del móvil");
        movil.setPrecio(scanner.nextDouble());
        System.out.println("Ingrese modelo del móvil");
        movil.setModelo(scanner.next());
        System.out.println("Ingrese memoria Ram del móvil");
        movil.setMemoriaRam(scanner.nextInt());
        System.out.println("Ingrese almacenamiento del móvil");
        movil.setAlmacenamiento(scanner.nextInt());
        ingresarCodigo();
        return movil;
    }
    
    public void ingresarCodigo() {
        int[] codigo = movil.getCodigo();
        for (int i = 0; i < 7; i++) {
            System.out.println("Ingrese número de código en posición: " + (i + 1));
            codigo[i] = scanner.nextInt();
        }
        movil.setCodigo(codigo);
    }
    
    public void mostrarMovil() {
        System.out.println(movil.toString());
    }
}
