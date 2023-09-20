package ejercicio_05;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora
debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para
ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando
consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
carácter fallido como un intento.*/
public class Ejercicio_05 {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int aleatorio = random.nextInt(10) + 1;
        boolean adivino = false;
        int intento = 0;

        while (!adivino) {
            try {
                System.out.println("Ingrese un número");
                int num = sc.nextInt();
                intento++;
                if (num == aleatorio) {
                    adivino = true;
                } else if (esMenor(num, aleatorio)) {
                    System.out.println("El número es menor al aleatorio");
                } else {
                    System.out.println("El número es mayor al aleatorio");
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Inválido.");
                sc.next();
                intento++;
            }
        }

        System.out.println("Adivinó en el intento " + (intento - 1) + ". El número aleatorio era el " + aleatorio);

    }

    public static boolean esMenor(int num, int aleat) {
        return num < aleat;
    }

}
