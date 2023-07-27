package ejercicios14a21;

import java.util.Scanner;

public class Ejercicio14 {

    /*Crea una aplicación que a través de una función nos convierta una cantidad de euros
introducida por teclado a otra moneda, estas pueden ser a dólares, yenes o libras. La
función tendrá como parámetros, la cantidad de euros y la moneda a converir que será
una cadena, este no devolverá ningún valor y mostrará un mensaje indicando el cambio
(void).
El cambio de divisas es:
* 0.86 libras es un 1 €
* 1.28611 $ es un 1 €
* 129.852 yenes es un 1 €*/
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese cantidad de euros");
        double cant = leer.nextDouble();
        System.out.println("Ingrese moneda a convertir");
        leer.nextLine();
        String moneda = leer.nextLine();
        
        convertirMoneda(cant, moneda);
    }

    public static void convertirMoneda(double euros, String moneda) {
        double[] divisas = {1.28611, 129.852, 0.86};
        double result = 0;

        if (moneda.substring(0, 1).equalsIgnoreCase("d")) {
            result += divisas[0] * euros;
        } else if (moneda.substring(0, 1).equalsIgnoreCase("y")) {
            result += divisas[1] * euros;
        } else {
            result += divisas[2] * euros;
        }
        
        System.out.println("El cambio de divisas a " + moneda + " es: " + result);
    }
}
