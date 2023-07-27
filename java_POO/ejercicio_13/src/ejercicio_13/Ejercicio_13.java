
package ejercicio_13;

import services.CursoService;

public class Ejercicio_13 {

    public static void main(String[] args) {
        
        CursoService cs = new CursoService();
        cs.crearCurso();
        cs.calcularGananciaSemanal();
    }

}
