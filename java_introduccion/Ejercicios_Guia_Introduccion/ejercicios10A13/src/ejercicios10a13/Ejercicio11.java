package ejercicios10a13;

import java.util.Scanner;

public class Ejercicio11 {

    /*Realizar un programa que pida dos números enteros positivos por teclado y muestre por
pantalla el siguiente menú:
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elija opción:
El usuario deberá elegir una opción y el programa deberá mostrar el resultado por pantalla
y luego volver al menú. El programa deberá ejecutarse hasta que se elija la opción 5.
Tener en cuenta que, si el usuario selecciona la opción 5, en vez de salir del programa
directamente, se debe mostrar el siguiente mensaje de confirmación: ¿Está seguro que
desea salir del programa (S/N)? Si el usuario selecciona el carácter ‘S’ se sale del
programa, caso contrario se vuelve a mostrar el menú.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el primer número");
        int num1 = leer.nextInt();
        System.out.println("Ingrese el segundo número");
        int num2 = leer.nextInt();

        boolean salir = false;

        do {
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            System.out.println("Ingrese una opción del menú");
            int opcion = leer.nextInt();
            leer.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("El resultado es: " + operar(num1, num2, "sumar"));
                    break;
                case 2:
                    System.out.println("El resultado es: " + operar(num1, num2, "restar"));
                    break;
                case 3:
                    System.out.println("El resultado es: " + operar(num1, num2, "multiplicar"));
                    break;
                case 4:
                    System.out.println("El resultado es: " + operar(num1, num2, "dividir"));
                    break;
                case 5:
                    System.out.println("Está seguro que desea salir?");
                    String confirm = leer.nextLine();
                    if (confirm.equalsIgnoreCase("s")) {
                        salir = true;
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (!salir);
    }

    public static int operar(int x, int y, String oper) {
        int result = 0;

        if (oper.equalsIgnoreCase("sumar")) {
            result += x + y;
        }
        if (oper.equalsIgnoreCase("restar")) {
            result += x - y;
        }
        if (oper.equalsIgnoreCase("multiplicar")) {
            result += x * y;
        }
        if (oper.equalsIgnoreCase("dividir")) {
            result += x / y;
        }
        return result;
    }

}
