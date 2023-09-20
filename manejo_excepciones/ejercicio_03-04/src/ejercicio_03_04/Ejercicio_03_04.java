package ejercicio_03_04;

import entities.DivisionNumero;
import java.util.InputMismatchException;
import java.util.Scanner;

/*3-Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos
números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer,
para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int. Por ultimo realizar
una división con los dos numeros y mostrar el resultado.*/

 /*4-Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena
no puede convertirse a entero, arroja una NumberFormatException y además, al dividir un
número por cero surge una ArithmeticException. Manipule todas las posibles excepciones
utilizando bloques try/catch para las distintas excepciones*/
public class Ejercicio_03_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        DivisionNumero dn = new DivisionNumero();
        System.out.println("Ingrese 2 números");
        try {
            String num1 = sc.next();
            String num2 = sc.next();
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            dn.dividir(n1, n2);
        } catch (InputMismatchException | NumberFormatException e) {  
            System.out.println(e.getMessage());
            System.out.println("Excepción: " + e);
        }
    }
    
    // InputMismatchException: Ej: ingresar string
    // NumberFormatException: Ej: ingresar double
    
    

}
