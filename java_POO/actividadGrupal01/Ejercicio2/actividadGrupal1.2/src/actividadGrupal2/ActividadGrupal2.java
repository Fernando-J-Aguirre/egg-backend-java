package actividadGrupal2;

import entities.Circulo;
import entities.Cuadrado;
import entities.Rectangulo;
import entities.Triangulo;
import java.util.Scanner;
import services.CirculoServicio;
import services.CuadradoServicio;
import services.RectanguloServicio;
import services.TrianguloServicio;

public class ActividadGrupal2 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Elegir figura: ");
        System.out.println("");
        System.out.println("1 - Cuadrado");
        System.out.println("2 - Rectangulo");
        System.out.println("3 - Triangulo");
        System.out.println("4 - Circulo");
        
        int figura = input.nextInt();
        
        switch (figura) {
            case 1:
                CuadradoServicio cs = new CuadradoServicio();
                Cuadrado cuadrado = cs.crearCuadrado();
                cs.calcularArea(cuadrado);
                cs.calcularPerimetro(cuadrado);
                break;
            case 2:
                RectanguloServicio rs = new RectanguloServicio();
                Rectangulo rectangulo = rs.crearRectangulo();
                rs.calcularArea(rectangulo);
                rs.calcularPerimetro(rectangulo);
                break;
            case 3:
                TrianguloServicio ts = new TrianguloServicio();
                Triangulo triangulo = ts.crearTriangulo();
                ts.calcularArea(triangulo);
                ts.calcularPerimetro(triangulo);
                break;
            case 4:
                CirculoServicio circuloS = new CirculoServicio();
                Circulo circulo = circuloS.crearCirculo();
                circuloS.calcularArea(circulo);
                circuloS.calcularPerimetro(circulo);
                break;
        }
    }
    
}
