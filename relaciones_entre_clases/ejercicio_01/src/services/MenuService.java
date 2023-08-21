package services;

import entities.Perro;
import java.util.Scanner;

public class MenuService {

    private final PerroService perroService;
    private final PersonaService personaService;
    private final Scanner sc;

    public MenuService(PerroService perroService, PersonaService personaService) {
        this.perroService = perroService;
        this.personaService = personaService;
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public void mostrarMenu() {
        System.out.println("Ingrese una opción del menú");
        int opcion;
        do {
            mostrarOpcionesMenu();
            opcion = sc.nextInt();
            menu(opcion);
        } while (opcion != 9);
    }

    private void mostrarOpcionesMenu() {
        System.out.println("1- Agregar perros");
        System.out.println("2- Mostrar perros");
        System.out.println("3- Buscar perro por nombre");
        System.out.println("4- Remover perro");
        System.out.println("5- Crear persona");
        System.out.println("6- Asignar perro/s");
        System.out.println("7- Mostrar persona");
        System.out.println("8- Disociar un perro de la persona");
        System.out.println("9- Salir");
    }

    private void menu(int opcion) {
        switch (opcion) {
            case 1:
                perroService.agregarPerros();
                break;
            case 2:
                perroService.mostrarPerros();
                break;
            case 3:
                System.out.println("Ingrese el nombre del perro que quiere buscar");
                String nombre = sc.next();
                Perro perro = perroService.buscarPerroPorNombre(nombre);
                if (perro != null) {
                    System.out.println(perro.toString());
                } else {
                    System.out.println("No se encuentra el perro con el nombre " + nombre);
                }
                break;
            case 4:
                System.out.println("Ingrese el nombre del perro que desea remover");
                String nombrePerr = sc.next();
                Perro perr = perroService.buscarPerroPorNombre(nombrePerr);
                if (perr != null) {
                    perroService.removerPerro(nombrePerr);
                    personaService.removerPerroDePersona(perr);
                } 
                break;
            case 5:
                personaService.crearPersona();
                break;
            case 6:
                personaService.asignarPerrosAPersona();
                break;
            case 7:
                personaService.mostrarPersona();
                break;
            case 8:
                System.out.println("Ingrese el nombre del perro que quiere disociar de la persona");
                String nombrePerro = sc.next();
                Perro perro1 = perroService.buscarPerroPorNombre(nombrePerro);
                if (perro1 != null) {
                    personaService.removerPerroDePersona(perro1);
                } else {
                    System.out.println("No existe perro con ese nombre");
                }
                break;
            case 9:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    }
}
