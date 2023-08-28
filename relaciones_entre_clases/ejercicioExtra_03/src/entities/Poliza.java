package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Poliza {

    private int numPoliza;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double montoTotalAsegurado;
    private boolean incluyeGranizo;
    private double montoMaxGranizo;
    private String tipoCobertura;
    private ArrayList<Cuota> listaCuotas;

    public Poliza() {
    }

    public Poliza(int numPoliza, LocalDate fechaInicio, LocalDate fechaFin, double montoTotalAsegurado, boolean incluyeGranizo, double montoMaxGranizo, String tipoCobertura, ArrayList<Cuota> listaCuotas) {
        this.numPoliza = numPoliza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaxGranizo = montoMaxGranizo;
        this.tipoCobertura = tipoCobertura;
        this.listaCuotas = listaCuotas;
    }

    public int getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoTotalAsegurado() {
        return montoTotalAsegurado;
    }

    public void setMontoTotalAsegurado(double montoTotalAsegurado) {
        this.montoTotalAsegurado = montoTotalAsegurado;
    }

    public boolean isIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public double getMontoMaxGranizo() {
        return montoMaxGranizo;
    }

    public void setMontoMaxGranizo(double montoMaxGranizo) {
        this.montoMaxGranizo = montoMaxGranizo;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public ArrayList<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(ArrayList<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }

    @Override
    public String toString() {
        return "Poliza{" + "numPoliza=" + numPoliza + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", montoTotalAsegurado=" + montoTotalAsegurado + ", incluyeGranizo=" + incluyeGranizo + ", montoMaxGranizo=" + montoMaxGranizo + ", tipoCobertura=" + tipoCobertura + ", listaCuotas=" + listaCuotas + '}';
    }

}
