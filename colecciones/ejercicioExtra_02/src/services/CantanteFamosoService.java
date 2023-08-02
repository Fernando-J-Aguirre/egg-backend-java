package services;

import entities.CantanteFamoso;
import java.util.ArrayList;
import java.util.Scanner;

public class CantanteFamosoService {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private final ArrayList<CantanteFamoso> cantantes = new ArrayList<>();

    public void agregarCantantes() {
        CantanteFamoso cf;
        System.out.println("Cuantos cantantes desea agregar?");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            cf = new CantanteFamoso();
            System.out.println("Ingrese nombre de cantante famoso " + (i + 1));
            cf.setNombre(scanner.next());
            System.out.println("Ingrese nombre de disco más vendido");
            cf.setDiscoConMasVentas(scanner.next());
            cantantes.add(cf);
        }
    }

    public void mostrar() {
        cantantes.forEach((e) -> System.out.println(e));
    }

    public void eliminarCantante(String nombre) {
        boolean eliminado = cantantes.removeIf(cantante -> cantante.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Cantante eliminado exitosamente");
        } else {
            System.out.println("No se encuentra cantante con ese nombre");
        }
    }

    public void menu() {
        boolean salir = false;
        do {
            System.out.println("MENU");
            System.out.println();
            System.out.println("1. Agregar cantantes");
            System.out.println("2. Eliminar cantante");
            System.out.println("3. Mostrar cantantes");
            System.out.println("4. Salir");
            System.out.println();
            System.out.println("Elija una opción del menú");
            System.out.println();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarCantantes();
                    break;
                case 2:
                    System.out.println("Indique el nombre del cantante a eliminar");
                    eliminarCantante(scanner.next());
                    break;
                case 3:
                    mostrar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (!salir);

    }

}
