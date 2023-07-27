
package ejercicio_14;

import services.MovilService;

public class Ejercicio_14 {

    public static void main(String[] args) {
        MovilService ms = new MovilService();
        ms.cargarCelular();   
        ms.mostrarMovil();
    }

}
