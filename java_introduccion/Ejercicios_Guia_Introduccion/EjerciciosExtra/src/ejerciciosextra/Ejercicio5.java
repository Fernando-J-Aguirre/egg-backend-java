package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio5 {

    /*Una obra social tiene tres clases de socios:
o Los socios tipo ‘A’ abonan una cuota mayor, pero tienen un 50% de descuento en
todos los tipos de tratamientos.
o Los socios tipo ‘B’ abonan una cuota moderada y tienen un 35% de descuento para
los mismos tratamientos que los socios del tipo A.
o Los socios que menos aportan, los de tipo ‘C’, no reciben descuentos sobre dichos
tratamientos.
o Solicite una letra (carácter) que representa la clase de un socio, y luego un valor
real que represente el costo del tratamiento (previo al descuento) y determine el
importe en efectivo a pagar por dicho socio.*/
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese tipo de socio A, B o C");
        String type = read.nextLine();
        System.out.println("Ingrese el costo del tratamiento");
        double cost = read.nextDouble();
        calculatePayment(type, cost);
    }

    public static void calculatePayment(String type, double cost) {
        switch (type.toLowerCase()) {
            case "a":
                cost *= 0.5;
                System.out.println("Al ser un socio de clase - A - tiene un descuento en su tratamiento del 50%, el importe a abonar es: $" + cost);
                break;
            case "b":
                cost *= 0.65;
                System.out.println("Al ser un socio de clase - B - tiene un descuento en su tratamiento del 35%, el importe a abonar es: $" + cost);
                break;
            case "c":
                System.out.println("Los socios de clase - C - no tienen descuento en tratamientos, el importe a abonar es: $" + cost);
                break;
            default:
                System.out.println("Tipo de socio inexistente");
        }
    }

}
