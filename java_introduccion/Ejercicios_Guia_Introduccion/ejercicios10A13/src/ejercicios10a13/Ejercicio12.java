package ejercicios10a13;

import java.util.Scanner;

public class Ejercicio12 {

    /*Realizar un programa que simule el funcionamiento de un dispositivo RS232, este tipo de
dispositivo lee cadenas enviadas por el usuario. Las cadenas deben llegar con un formato
fijo: tienen que ser de un máximo de 5 caracteres de largo, el primer carácter tiene que ser
X y el último tiene que ser una O.
Las secuencias leídas que respeten el formato se consideran correctas, la secuencia
especial “&&&&&” marca el final de los envíos (llamémosla FDE), y toda secuencia distinta
de FDE, que no respete el formato se considera incorrecta.
Al finalizar el proceso, se imprime un informe indicando la cantidad de lecturas correctas e
incorrectas recibidas. Para resolver el ejercicio deberá investigar cómo se utilizan las
siguientes funciones de Java Substring(), Length(), equals().*/
    public static void main(String[] args) {
        int correctas, incorrectas;
        boolean esCorrecta, fde;
        correctas = 0;
        incorrectas = 0;
        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Ingrese secuencia");
            String cadena = leer.nextLine();

            esCorrecta = verificarSecuencia(cadena);
            fde = verificarEspecial(cadena);

            if (esCorrecta && !fde) {
                correctas++;
            } else if (!fde) {
                incorrectas++;
            }
        } while (!fde);

        System.out.println("Correctas: " + correctas);
        System.out.println("Incorrectas: " + incorrectas);
    }

    public static boolean verificarSecuencia(String sec) {
        boolean verified = false;
        if ((sec.length() >= 2)
                && (sec.length() <= 5)
                && sec.substring(0, 1).equals("X")
                && sec.substring(sec.length() - 1).equals("O")) {
            verified = true;
        }
        return verified;
    }

    public static boolean verificarEspecial(String sec) {
        boolean verif = false;
        int contador = 0;
        if (sec.length() == 5) {
            for (int i = 0; i < sec.length(); i++) {
                if (!sec.substring(i, i + 1).equals("&")) {
                    verif = false;
                    return verif;
                } else {
                    contador++;
                }
            }
            if (contador == 5) {
                verif = true;
            }
        }
        return verif;
    }
}
