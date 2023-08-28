package entities;

import java.time.LocalDate;

public class Cuota {

    private int numero;
    private double monto;
    private boolean pagada;
    private LocalDate fechaVencimiento;
    private String formaDePago;

    public Cuota() {
    }

    public Cuota(int numero, double monto, boolean pagada, LocalDate fechaVencimiento, String formaDePago) {
        this.numero = numero;
        this.monto = monto;
        this.pagada = pagada;
        this.fechaVencimiento = fechaVencimiento;
        this.formaDePago = formaDePago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString() {
        return "Cuota{" + "numero=" + numero + ", pagada=" + pagada + ", fechaVencimiento=" + fechaVencimiento + ", formaDePago=" + formaDePago + '}';
    }

}
