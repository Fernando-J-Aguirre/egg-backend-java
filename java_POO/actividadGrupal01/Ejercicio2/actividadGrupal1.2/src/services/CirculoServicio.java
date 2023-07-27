package services;

import entities.Circulo;
import java.util.Scanner;

public class CirculoServicio {
    
    private Scanner input = new Scanner(System.in);
    
    public Circulo crearCirculo() {
        
        System.out.println("Ingresar radio: ");
        float radio = input.nextFloat();
        
        return new Circulo(radio);
    }
    
    public void calcularArea(Circulo circulo) {
        double area = Math.PI * (Math.pow(circulo.getRadio(), 2));
        
        System.out.println("Area Circulo: " + area);
    }
    
    public void calcularPerimetro(Circulo circulo) {
        double perimetro = 2 * Math.PI * circulo.getRadio();
        
        System.out.println("Perimetro Circulo: " + perimetro);
    }
}
