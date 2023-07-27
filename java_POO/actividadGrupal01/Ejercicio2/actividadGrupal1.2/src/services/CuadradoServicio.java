package services;

import entities.Cuadrado;
import java.util.Scanner;

public class CuadradoServicio {
    
    private Scanner input = new Scanner(System.in);
    
    public Cuadrado crearCuadrado() {
        
        System.out.println("Ingresar lado: ");
        int lado = input.nextInt();
        
        return new Cuadrado(lado);
    }
    
    public void calcularArea(Cuadrado cuadrado) {
        int lado = cuadrado.getlado();
        int area = lado * lado;
        
        System.out.println("Area Cuadrado: " + area);
    }
    
    public void calcularPerimetro(Cuadrado cuadrado) {
        int lado = cuadrado.getlado();
        int perimetro = lado * 4;
        
        System.out.println("Perimetro Cuadrado: " + perimetro);
    }
}
