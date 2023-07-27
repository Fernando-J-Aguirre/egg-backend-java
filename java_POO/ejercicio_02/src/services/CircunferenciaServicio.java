
package services;

import entities.Circunferencia;
import java.util.Scanner;

public class CircunferenciaServicio {
    
    public Circunferencia crearCircunferencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el radio de la circunferencia");
        double radio = scanner.nextDouble();        
        return new Circunferencia(radio);
    }
    
    public void area(Circunferencia cir) {
        double area = (Math.floor((Math.PI * Math.pow(cir.getRadio(), 2)) * 100)) / 100;
        System.out.println("El área de la circunferencia es = " + area);
    }
    
    public void perimetro(Circunferencia cir) {
        double perimetro = (Math.floor((2 * Math.PI * cir.getRadio()) * 100)) / 100;
        System.out.println("El perímetro de la circunferencia es = " + perimetro);
    }
}
