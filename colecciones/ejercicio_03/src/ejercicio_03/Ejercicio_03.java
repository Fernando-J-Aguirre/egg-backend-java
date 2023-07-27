
package ejercicio_03;

import services.AlumnoService;

public class Ejercicio_03 {

    public static void main(String[] args) {
        
        AlumnoService as = new AlumnoService();
        
        as.crearAlumnos();
        System.out.println("Nota final:");
        System.out.println(as.notaFinal("Roberto"));
        
    }

}
