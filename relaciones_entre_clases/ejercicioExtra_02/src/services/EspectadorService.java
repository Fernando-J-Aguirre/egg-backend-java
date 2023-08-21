package services;

import entities.Espectador;
import java.util.Scanner;

public class EspectadorService {

    private Scanner sc;

    public EspectadorService() {
        sc = new Scanner(System.in).useDelimiter("\n");
    }

    public Espectador crearEspectador() {
        Espectador espectador = new Espectador();
        System.out.println("Ingrese nombre de espectador");
        espectador.setNombre(sc.next());
        System.out.println("Ingrese edad");
        espectador.setEdad(sc.nextInt());
        System.out.println("Ingrese dinero disponible");
        espectador.setDinero(sc.nextDouble());
        return espectador;
    }
    

}
