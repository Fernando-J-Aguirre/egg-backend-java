package services;

import entities.Perro;
import entities.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonaService {

    private final PerroService perroService;
    private final Scanner sc;
    private final Persona persona;

    public PersonaService(PerroService perroService) {
        this.perroService = perroService;
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.persona = new Persona();
    }

    public void crearPersona() {
        System.out.println("Ingrese nombre");
        persona.setNombre(sc.next());
        System.out.println("Ingrese apellido");
        persona.setApellido(sc.next());
        System.out.println("Ingrese edad");
        persona.setEdad(sc.nextInt());
        System.out.println("Ingrese documento");
        persona.setDocumento(sc.nextInt());
        System.out.println("Desea asignar uno o más perros? (s/n)");
        if (sc.next().equalsIgnoreCase("s")) {
            asignarPerrosAPersona();
            System.out.println("Persona creada exitosamente, con perro/s asignado/s");
            return;
        }
        System.out.println("Persona creada exitosamente pero sin perros asignado aún");
    }

    public void asignarPerrosAPersona() {
        System.out.println("Perros disponibles");
        perroService.mostrarPerros();
        System.out.println("Ingrese el nombre del perro a asignar");
        String nombre = sc.next();
        Perro perro = perroService.buscarPerroPorNombre(nombre);
        if (perro != null) {
            persona.getPerros().add(perro);
            System.out.println("Perro asignado correctamente");
        } else {
            System.out.println("No se encontró un perro que se llame " + nombre);
        }
    }

    public void removerPerroDePersona(Perro perro) {
        ArrayList<Perro> perros = persona.getPerros();
        if (perros.remove(perro)) {
            persona.setPerros(perros);
            System.out.println("Perro eliminado de la lista de perros de la persona");
        } else {
            System.out.println("El perro no se encuentra en la lista de perros asignados de la persona");
        }
    }

    public void mostrarPersona() {
        System.out.println(persona);
    }

}
