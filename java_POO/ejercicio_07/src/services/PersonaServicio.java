package services;

import entities.Persona;
import java.util.Scanner;

public class PersonaServicio {

    Persona persona = new Persona();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {
        System.out.println("Ingrese nombre:");
        persona.setNombre(scanner.next());
        System.out.println("Ingrese edad:");
        persona.setEdad(scanner.nextInt());
        System.out.println("Ingrese sexo(H, M, O):");
        String sexo = scanner.next();
        while (!sexo.equalsIgnoreCase("h") && !sexo.equalsIgnoreCase("m") && !sexo.equalsIgnoreCase("o")) {
            System.out.println("Caracter inválido. Por favor, ingrese nuevamente el sexo");
            sexo = scanner.next();
        }
        persona.setSexo(sexo);
        System.out.println("Ingrese su peso:");
        persona.setPeso(scanner.nextDouble());
        System.out.println("Ingrese su altura:");
        persona.setAltura(scanner.nextDouble());
        return persona;
    }

    public int calcularIMC() {
        double peso = persona.getPeso();
        double altura = persona.getAltura();
        double resultado = peso / Math.pow(altura, 2);
        if (resultado < 20) {
            return -1;
        } else if (resultado <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return persona.getEdad() >= 18;
    }
    
    public String mostrar() {
        return persona.toString();
    }

}
