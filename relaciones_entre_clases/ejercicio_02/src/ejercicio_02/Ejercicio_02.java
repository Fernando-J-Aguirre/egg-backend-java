package ejercicio_02;

import services.JuegoService;
import services.JugadorService;
import services.RevolverService;

public class Ejercicio_02 {

    public static void main(String[] args) {
        RevolverService rs = new RevolverService();
        JugadorService js = new JugadorService(rs);        
        JuegoService juegoService = new JuegoService(rs, js);
        juegoService.jugar();
        
    }

}
