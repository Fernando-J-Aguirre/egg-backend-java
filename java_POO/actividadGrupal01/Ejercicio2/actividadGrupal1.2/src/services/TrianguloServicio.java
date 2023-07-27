package services;

import entities.Triangulo;
import java.util.Scanner;

public class TrianguloServicio {
    
    private Scanner input = new Scanner(System.in);
    
    public Triangulo crearTriangulo() {
        
        System.out.println("Ingresar base: ");
        int base = input.nextInt();
        
        System.out.println("Ingresar altura: ");
        int altura = input.nextInt();
        
        return new Triangulo(base, altura);
    }
    
    public void calcularArea(Triangulo Triangulo) {
        int area = (Triangulo.getBase() * Triangulo.getAltura()) / 2;
        
        System.out.println("Area Triangulo: " + area);
    }
    
    public void calcularPerimetro(Triangulo Triangulo) {
        int perimetro = Triangulo.getBase() * 3;
        
        System.out.println("Perimetro Triangulo: " + perimetro);
    }
}
