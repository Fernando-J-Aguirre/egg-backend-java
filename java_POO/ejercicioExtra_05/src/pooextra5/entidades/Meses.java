package pooextra5.entidades;

import java.util.Scanner;

public class Meses {

    private final String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    private final String mesSecreto = meses[(int) (Math.random() * 12)];

    public void esMesSecreto() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.println("SECRETO: " + mesSecreto);
        String mesUsuario;

        do {
            System.out.println("Ingrese un mes: ");
            mesUsuario = input.nextLine().toLowerCase();

            if (!mesUsuario.equals(mesSecreto)) {
                System.out.println("No ha acertado, vuelva a intentar...");
            }

        } while (!mesUsuario.equals(mesSecreto));

        System.out.println("¡Ha acertado!");

    }

}
