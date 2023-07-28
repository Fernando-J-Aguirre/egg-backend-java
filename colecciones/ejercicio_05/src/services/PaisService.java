package services;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import entities.Pais;

public class PaisService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    HashSet<Pais> paises = new HashSet<>();

    public void guardarPaises() {
        boolean continuar = true;
        while (continuar) {
            Pais pais = new Pais();
            System.out.println("Ingrese un pais para ser guardado: ");
            pais.setNombre(sc.next());
            paises.add(pais);
            System.out.println("¿Desea guardar otro pais? (S/N)");
            if (sc.next().equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
    }

    public void mostrarPaises() {
        System.out.println("Paises guardados: ");
        for (Pais pais : paises) {
            System.out.println(pais.getNombre());
        }
    }

    public void ordenarPaisesAsc() {
        TreeSet<Pais> paisSet = new TreeSet<>(paises);

        System.out.println("Paises ordenados ascendentemente: ");
        for (Pais pais : paisSet) {
            System.out.println(pais.getNombre());
        }
    }

    public void eliminarPais() {
        System.out.println("Ingrese el nombre del pais a eliminar: ");
        String nombre = sc.next();

        for (Pais pais : paises) {
            if (pais.getNombre().equalsIgnoreCase(nombre)) {
                paises.remove(pais);
                return;
            }
        }
    }

}
