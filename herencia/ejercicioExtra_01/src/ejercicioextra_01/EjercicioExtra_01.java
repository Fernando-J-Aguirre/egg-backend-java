
package ejercicioextra_01;

import entities.Alquiler;
import entities.YateDeLujo;
import java.time.LocalDate;

public class EjercicioExtra_01 {

    public static void main(String[] args) {
        YateDeLujo y = new YateDeLujo(5, 80, "AB93A", 15, 1959);
        
        Alquiler alquiler = new Alquiler("Juan", "35435435", LocalDate.of(2023, 03, 15), LocalDate.of(2023, 04, 20), 5, y);
        
        int dias = alquiler.getFechaDevolucion().getDayOfYear() - alquiler.getFechaAlquiler().getDayOfYear();
        
        System.out.println(dias * y.calcularModulo());
        
        
    }

}
