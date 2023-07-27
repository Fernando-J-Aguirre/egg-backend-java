package services;

import entities.Rectangulo;
import java.util.Scanner;

public class RectanguloServicio {
    
    private Scanner input = new Scanner(System.in);
    
    public Rectangulo crearRectangulo() {
        
        System.out.println("Ingresar base: ");
        int base = input.nextInt();
        
        System.out.println("Ingresar altura: ");
        int altura = input.nextInt();
        
        return new Rectangulo(base, altura);
    }
    
    public void calcularArea(Rectangulo rectangulo) {
        int area = rectangulo.getBase() * rectangulo.getAltura();
        
        System.out.println("Area Rectangulo: " + area);
    }
    
    public void calcularPerimetro(Rectangulo rectangulo) {
        int perimetro = (rectangulo.getBase() + rectangulo.getAltura()) * 2;
        
        System.out.println("Perimetro Rectangulo: " + perimetro);
    }
}
