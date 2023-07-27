
package services;

import entities.Persona;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PersonaService {
    
    Persona persona = new Persona();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        
    public void crearPersona() {
        System.out.println("Ingrese su nombre");
        persona.setNombre(scanner.next());
        System.out.println("Ingrese fecha de nacimiento en el siguiente formato: yyyy-mm-dd");
        LocalDate fechaNac = LocalDate.parse(scanner.next());
        persona.setFechaNacimiento(fechaNac);
    }
    
    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(persona.getFechaNacimiento(), hoy);
        return period.getYears();
    }
    
    public boolean menorQue(int edad) {
        int edadActual = calcularEdad();
        return edadActual < edad;
    }
    
    public void mostrarPersona() {
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + persona.getFechaNacimiento());
        System.out.println("Edad: " + calcularEdad() + " años");
    }
    
    
}
