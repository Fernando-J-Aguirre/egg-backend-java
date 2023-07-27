package ejercicios10a13;

import java.util.Scanner;

public class Ejercicio10 {

    /*Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación solicite
números al usuario hasta que la suma de los números introducidos supere el límite inicial.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int suma = 0;
        System.out.println("Ingrese valor límite positivo");
        int limite = leer.nextInt();

        while (limite < 0) {
            System.out.println("Inválido, ingrese valor límite positivo");
        }
        
        while(suma < limite) {
            System.out.println("Ingrese un número");
            suma += leer.nextInt();
        }
        System.out.println("La suma total: " + suma + " superó el límite: " + limite);
        
    }

}
