package ejercicio_03;

import servicies.BarajaService;

public class Ejercicio_03 {

    public static void main(String[] args) {

        BarajaService bs = new BarajaService();
        bs.crearCartas();
        System.out.println("-------");
        System.out.println("BARAJAR");
        bs.barajar();
        System.out.println("-------");
        System.out.println("CARTAS DISPONIBLES");
        bs.cartasDisponibles();
        System.out.println("-------");
        System.out.println("SIGUIENTE CARTA");
        bs.siguienteCarta();
        bs.siguienteCarta();
        bs.siguienteCarta();
        bs.siguienteCarta();
        System.out.println("MOSTRAR CARTAS");
        bs.mostrarBaraja();
        System.out.println("-------");
        System.out.println("CARTAS DISPONIBLES");
        bs.cartasDisponibles();
        System.out.println("-------");
        System.out.println("DAR CARTAS");
        bs.darCartas();
        System.out.println("-------");
        System.out.println("CARTAS DISPONIBLES");
        bs.cartasDisponibles();
        System.out.println("-------");
        System.out.println("CARTAS MONTON");
        bs.cartasMonton();
        System.out.println("-------");
        System.out.println("MOSTRAR CARTAS");
        bs.mostrarBaraja();
    }

}
