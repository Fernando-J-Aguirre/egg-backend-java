package services;

import entities.Asiento;
import entities.Espectador;
import entities.LetraAsiento;
import entities.Sala;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SalaService {

    private Sala sala;
    private ArrayList<ArrayList<Asiento>> asientos;
    private LinkedHashMap<Asiento, Espectador> asientosOcupados;
    private ArrayList<Espectador> espectadores;

    public SalaService() {
        sala = new Sala();
        asientos = new ArrayList<>();
        asientosOcupados = new LinkedHashMap<>();
        espectadores = new ArrayList<>();
    }

    public Sala crearSala() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("¿Desea ingresar espectadores ahora? S/N");
        if (sc.next().equalsIgnoreCase("s")) {
            System.out.println("Ingrese cantidad de espectadores");
            int cantidad = sc.nextInt();
            crearEspectadores(cantidad);
        }
        crearAsientosVacios();
        sala.setCantidadDisponibles(48);
        sala.setAsientos(asientos);
        return sala;
    }

    private void crearAsientosVacios() {
        for (int i = 8; i > 0; i--) {
            ArrayList<Asiento> filaAsientos = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                Asiento nuevoAsiento = new Asiento();
                nuevoAsiento.setNumero(i);
                nuevoAsiento.setLetra(LetraAsiento.values()[j]);
                nuevoAsiento.setOcupado(false);
                filaAsientos.add(nuevoAsiento);
            }
            asientos.add(filaAsientos);
        }
    }

    public void mostrarAsientos() {
        for (ArrayList<Asiento> filaAsiento : sala.getAsientos()) {
            for (int i = 0; i < 6; i++) {
                System.out.print(filaAsiento.get(i));
                if (i < 5) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public boolean asientoDisponible(int num, LetraAsiento letra, Espectador espectador) {
        int columna = letra.ordinal();
        if (!sala.getAsientos().get(8 - num).get(columna).isOcupado()) {
            ocuparAsiento(8 - num, columna, espectador);
            return true;
        }
        return false;
    }

    private void ocuparAsiento(int fila, int col, Espectador espectador) {
        Asiento asientoOcupado = sala.getAsientos().get(fila).get(col);
        asientoOcupado.setOcupado(true);
        asientoOcupado.setEspectador(espectador);
        asientosOcupados.put(asientoOcupado, espectador);
    }

    public void verEspectadoresEnAsiento() {
        for (Map.Entry<Asiento, Espectador> entry : asientosOcupados.entrySet()) {
            Asiento key = entry.getKey();
            Espectador value = entry.getValue();
            System.out.println("Espectador: " + value.getNombre() + " - " + "Fila: " + key.getNumero() + " Columna: " + key.getLetra());
        }
    }
    
    public void buscarUbicacionDeEspectador() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese nombre del espectador para buscar su ubicación");
        String nombre = sc.next();
        for (Map.Entry<Asiento, Espectador> entry : asientosOcupados.entrySet()) {
            Asiento key = entry.getKey();
            Espectador value = entry.getValue();
            if(value.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Se encontró espectador/a");
                System.out.println(value.getNombre() + " - " + "Fila: " + key.getNumero() + " Columna: " + key.getLetra());
                return;
            }
        }
        System.out.println("No existe espectador/a con ese nombre");
        
    }

    public void crearEspectadores(int cantidad) {
        EspectadorService es = new EspectadorService();
        espectadores = sala.getEspectadores();
        for (int i = 0; i < cantidad; i++) {
            espectadores.add(es.crearEspectador());
        }
        sala.setEspectadores(espectadores);
    }

}
