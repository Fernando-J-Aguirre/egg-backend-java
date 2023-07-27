package ejercicioextra_04;

import services.NifService;

public class EjercicioExtra_04 {

    public static void main(String[] args) {
        NifService ns = new NifService();
        ns.crearNif();
        ns.mostrar();
    }

}
