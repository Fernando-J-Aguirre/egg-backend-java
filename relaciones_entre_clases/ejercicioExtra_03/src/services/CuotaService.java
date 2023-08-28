package services;

import entities.Cuota;
import java.time.LocalDate;
import java.util.Scanner;

public class CuotaService {
    
    private Scanner sc;
    private Cuota cuota;
    
    public CuotaService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        cuota = new Cuota();
    }
    
    public Cuota crearCuota(int numeroCuota, double montoTotal, int meses) {
        cuota.setNumero(numeroCuota);
        cuota.setMonto(montoTotal / meses);
        cuota.setPagada(false);
        LocalDate now = LocalDate.now();
        LocalDate fechaVencimiento = now.plusDays(30);
        cuota.setFechaVencimiento(fechaVencimiento);
        cuota.setFormaDePago("Débito automático");
        return cuota;
    }
    
    
    
}
