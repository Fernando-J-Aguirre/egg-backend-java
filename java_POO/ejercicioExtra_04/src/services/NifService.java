package services;

import entities.Nif;
import java.util.Scanner;

public class NifService {

    Nif nif = new Nif();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public void crearNif() {
        System.out.println("Ingrese DNI");
        long dni = scanner.nextLong();
        nif.setDni(dni);
        calcularLetra(dni);
    }

    private char calcularLetra(long dni) {
        char[] caract = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = (int) (dni % 23);
        System.out.println(resto);
        nif.setLetra(caract[resto]);
        return caract[resto];
    }

    public void mostrar() {
        System.out.println("NIF");
        System.out.println(nif.getDni() + "-" + nif.getLetra());
    }

}
