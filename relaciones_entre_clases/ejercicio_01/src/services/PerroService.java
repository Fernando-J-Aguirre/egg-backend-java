package services;

import entities.Perro;
import entities.Tamanio;
import java.util.ArrayList;
import java.util.Scanner;

public class PerroService {

    private final Scanner sc; 
    private final ArrayList<Perro> perros;

    public PerroService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        perros = new ArrayList<>();
    }
    
    public Perro crearPerro() {
        Perro perro = new Perro();
        System.out.println("Ingrese el nombre del perro");
        perro.setNombre(sc.next());
        System.out.println("Ingrese la raza del perro");
        perro.setRaza(sc.next());
        System.out.println("Ingrese la edad del perro");
        perro.setEdad(sc.nextInt());
        System.out.println("Ingrese el tamaño del perro (grande, mediano, chico)");
        String tamanio = sc.next();
        for (Tamanio aux : Tamanio.values()) {
            if (aux.toString().equalsIgnoreCase(tamanio)) {
                perro.setTamanio(aux);
                break;
            }
        }
        return perro;
    }

    public void agregarPerros() {
        System.out.println("Cuantos perros desea agregar");
        int cant = sc.nextInt();
        for (int i = 0; i < cant; i++) {
            perros.add(crearPerro());
        }
    }

    public void mostrarPerros() {
        System.out.println(perros);
    }

    public Perro buscarPerroPorNombre(String nombre) {
        for (Perro perro : perros) {
            if (perro.getNombre().equalsIgnoreCase(nombre)) {
                return perro;
            }
        }
        return null;
    }

    public void removerPerro(String nombre) {
        boolean remov = perros.removeIf(perro -> perro.getNombre().equalsIgnoreCase(nombre));
        if (remov) {
            System.out.println("Perro removido exitosamente");
            return;
        }
        System.out.println("No se encuentra perro con ese nombre");
    }

}
