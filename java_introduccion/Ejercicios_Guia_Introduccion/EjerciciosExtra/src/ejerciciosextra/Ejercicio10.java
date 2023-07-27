package ejerciciosextra;

import java.util.Scanner;

public class Ejercicio10 {

    /*Realice un programa para que el usuario adivine el resultado de una multiplicación entre
dos números generados aleatoriamente entre 0 y 10. El programa debe indicar al usuario
si su respuesta es o no correcta. En caso que la respuesta sea incorrecta se debe permitir
al usuario ingresar su respuesta nuevamente. Para realizar este ejercicio investigue como
utilizar la función Math.random() de Java.*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean adivino = false;
        int random = generarAleatorio();
        System.out.println(random);
        int contador = 3;
        int num;
        System.out.println("Intente adivinar el número, tiene 3 intentos");
        do {
            contador--;
            num = leer.nextInt();
            if (num == random) {
                System.out.println("Respuesta correcta");
                adivino = true;
            } else if (contador != 0) {
                System.out.println("Respuesta incorrecta, le quedan " + contador + " intentos");
            } else {
                break;
            }
        } while (!adivino && contador > 0);
        if (contador == 0 && !adivino) {
            System.out.println("Incorrecto. El número era " + random);
        }

    }

    public static int generarAleatorio() {
        int aleat1, aleat2, random;
        aleat1 = (int) (Math.random() * 10);
        aleat2 = (int) (Math.random() * 10);
        return random = aleat1 * aleat2;
    }

}
