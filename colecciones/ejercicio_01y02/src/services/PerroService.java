package services;

import entities.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PerroService {

    private ArrayList<Perro> perros;
    private Scanner scanner;

    public PerroService() {
        this.perros = new ArrayList<>();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Perro crearPerro() {
        System.out.println("Ingrese una raza de perro");
        String raza = scanner.next();

        return new Perro(raza);
    }

    public void agregarPerro(Perro perro) {
        perros.add(perro);
    }

    public void mostrarPerros() {
        for (Perro var : perros) {
            System.out.println(var.toString());
        }
    }

    public void eliminarPerroConIterator(String raza) {
        boolean encontrado = false;
        Iterator<Perro> it = perros.iterator();
        while (it.hasNext() && !encontrado) {
            if (it.next().getRaza().equals(raza)) {
                it.remove();
                encontrado = true;
                System.out.println("Eliminado exitosamente");
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró la raza proporcionada");
        }
    }

    public void iniciarPrograma() {

        boolean continuar = true;

        do {
            Perro perro = crearPerro();
            agregarPerro(perro);
            System.out.println("¿Desea continuar agregando razas de perro? S/N");
            String res = scanner.next();
            if (res.equalsIgnoreCase("n")) {
                continuar = false;
            }

        } while (continuar);

        mostrarPerros();

        System.out.println("Ingrese una raza de perro a eliminar");
        String raza = scanner.next();
        eliminarPerroConIterator(raza);

        mostrarPerros();

    }

}
