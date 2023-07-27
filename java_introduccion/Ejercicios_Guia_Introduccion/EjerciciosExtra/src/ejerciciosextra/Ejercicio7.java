package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio7 {

    /*Realice un programa que calcule y visualice el valor máximo, el valor mínimo y el promedio
de n números (n>0). El valor de n se solicitará al principio del programa y los números
serán introducidos por el usuario. Realice dos versiones del programa, una usando el
bucle “while” y otra con el bucle “do - while”.*/
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números que va a ingresar");
        int n = read.nextInt();
        int total = 0;
        int max = 0;
        int min = 0;
        int counter = 0;
        int number;
// con while
        while (counter < n) {
            System.out.println("Ingrese número " + (counter + 1) + " = ");
            number = read.nextInt();
            if (counter == 0) {
                max = number;
                min = number;
            }
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            total += number;
            counter++;
        }
        System.out.println("CON WHILE");
        System.out.println("El valor mínimo es = " + min);
        System.out.println("El valor máximo es = " + max);
        System.out.println("El promedio es = " + total / n);
// con do-while
//        do {

//            System.out.println("Ingrese número " + (counter + 1) + " = ");
//            number = read.nextInt();
//            if (counter == 0) {
//                max = number;
//                min = number;
//            }
//            if (number < min) {
//                min = number;
//            }
//            if (number > max) {
//                max = number;
//            }
//            total += number;2
//            counter++;
//        } while (counter < n);
//        System.out.println("CON DO-WHILE");
//        System.out.println("El valor mínimo es = " + min);
//        System.out.println("El valor máximo es = " + max);
//        System.out.println("El promedio es = " + total / n);

//        CON FUNCIÓN
//        int[] numbers = new int[n]; //esto es para la funcion calculateMaxMinAver()
//        for (int i = 0; i < numbers.length; i++) { //
//            System.out.println("Ingrese número " + (i + 1)); //
//            numbers[i] = read.nextInt(); //
//        }
//        calculateMaxMinAver(numbers);
    }

    public static void calculateMaxMinAver(int[] numbers) {
        int total = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            total += numbers[i];
        }
        System.out.println("El valor mínimo es = " + min);
        System.out.println("El valor máximo es = " + max);
        System.out.println("El promedio es = " + total / numbers.length);
    }

}
