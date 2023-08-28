package services;

import entities.Cuota;
import entities.Poliza;
import entities.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PolizaService {

    private Scanner sc;
    private CuotaService cuotaService;
    private ArrayList<Cuota> cuotas;
    private ArrayList<Poliza> polizas;

    public PolizaService(CuotaService cuotaService) {
        sc = new Scanner(System.in).useDelimiter("\n");
        this.cuotaService = cuotaService;
        cuotas = new ArrayList<>();
        polizas = new ArrayList<>();
    }

    public Poliza crearPoliza() {
        Poliza poliza = new Poliza();
        System.out.println("Ingrese número de póliza");
        poliza.setNumPoliza(sc.nextInt());
        LocalDate now = LocalDate.now();
        poliza.setFechaInicio(now);
        System.out.println("Ingrese la cantidad de meses de la póliza");
        int meses = sc.nextInt();
        LocalDate fechaVencimiento = now.plusMonths(meses);
        poliza.setFechaFin(fechaVencimiento);
        System.out.println("Ingrese el monto total asegurado");
        double montoTotal = sc.nextDouble();
        poliza.setMontoTotalAsegurado(montoTotal);
        System.out.println("Desea incluir cobertura contra granizo? S/N");
        if (sc.next().equalsIgnoreCase("s")) {
            poliza.setIncluyeGranizo(true);
            System.out.println("Ingrese monto Maximo contra granizo");
            poliza.setMontoMaxGranizo(sc.nextDouble());
        } else {
            poliza.setIncluyeGranizo(false);
            poliza.setMontoMaxGranizo(0);
        }
        System.out.println("Ingrese tipo de cobertura");
        poliza.setTipoCobertura(sc.next());
        for (int i = 0; i < meses; i++) {
            Cuota cuota = cuotaService.crearCuota((i + 1), montoTotal, meses);
            cuotas.add(cuota);
        }
        poliza.setListaCuotas(cuotas);
        polizas.add(poliza);
        return poliza;
    }

    public Poliza getByPolizaNumber(int number) {
        for (Poliza poliza : polizas) {
            if (poliza.getNumPoliza() == number) {
                return poliza;
            }
        }
        return null;
    }

    public Poliza buscarPolizaDeVehiculo(Vehiculo vehiculo) {
        for (Poliza poliza : polizas) {
            if (vehiculo.getPoliza().equals(poliza)) {
                return poliza;
            }
        }
        return null;
    }

    public ArrayList<Poliza> getAllPolizas() {
        return polizas;
    }

    public void deletePoliza(Vehiculo vehiculo) {
        if (polizas.contains(vehiculo.getPoliza())) {
            polizas.removeAll(vehiculo.getPoliza().getListaCuotas());
            polizas.remove(vehiculo.getPoliza());
        }
    }
    
}
