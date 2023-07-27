
package ejercicio_12;

import services.PersonaService;

public class Ejercicio_12 {

    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        
        ps.crearPersona();
        System.out.println(ps.menorQue(28));
        ps.mostrarPersona();
        
    }

}
