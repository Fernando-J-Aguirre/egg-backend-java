package servicies;

import entities.Baraja;
import entities.Carta;
import entities.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BarajaService {

    private final ArrayList<Carta> cartas;
    private final Baraja baraja;
    private final ArrayList<Carta> cartasNoDisp;
    private final Scanner sc;

    public BarajaService() {
        cartas = new ArrayList<>(40);
        baraja = new Baraja();
        cartasNoDisp = new ArrayList<>();
        sc = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearCartas() {
        for (Palo palo : Palo.values()) {
            for (int j = 1; j <= 12; j++) {
                if (j != 8 && j != 9) {
                    Carta carta = new Carta();
                    carta.setNum(j);
                    carta.setPalo(palo);
                    cartas.add(carta);
                }
            }
        }
        baraja.setCartas(cartas);
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public void siguienteCarta() {
        if (cartas.get(0) != null) {
            System.out.println(cartas.get(0));
            cartasNoDisp.add(cartas.get(0));
            cartas.remove(0);
            baraja.setCartas(cartas);
        } else {
            System.out.println("No hay más cartas");
        }
    }

    public void cartasDisponibles() {
        System.out.println("Cartas disponibles = " + baraja.getCartas().size());
    }

    public void darCartas() {
        System.out.println("Cuántas cartas quiere repartir?");
        int cantidad = sc.nextInt();
        if (cantidad < cartas.size()) {
            for (int i = 0; i < cantidad; i++) {
                siguienteCarta();
            }
        } else {
            System.out.println("La cantidad de cartas pedidas supera las disponibles");
        }
    }
    
    public void cartasMonton() {
        if(cartasNoDisp.size() > 0) {
            System.out.println(cartasNoDisp.size());
            System.out.println(cartasNoDisp);
        } else {
            System.out.println("Aún no ha salido ninguna carta");
        }
    }

    public void mostrarBaraja() {
        System.out.println(baraja.getCartas());
        System.out.println(baraja.getCartas().size());
    }

}
