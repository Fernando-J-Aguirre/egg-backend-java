package entities;

import java.util.Scanner;

public class Rectangulo {

    private double base;
    private double altura;

    public Rectangulo() {
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

    public void crearReactangulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la base del rectángulo: ");
        base = scanner.nextDouble();

        System.out.println("Ingrese la altura del rectángulo: ");
        altura = scanner.nextDouble();
    }
    
    public void calcularSuperficie() {
        double superficie = base * altura;
        System.out.println("La superficie del rectángulo es: " + superficie);
    }
    
    public void calcularPerimetro() {
        double perimetro = (base + altura) * 2;
        System.out.println("La superficie del rectángulo es: " + perimetro);
    }
    
}
