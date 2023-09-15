package entities;

public final class Velero extends Barco {

    private int cantidadMastiles;

    public Velero(int cantidadMastiles, String matricula, double eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.cantidadMastiles = cantidadMastiles;
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
    
    @Override
    public double calcularModulo() {
        return super.calcularModulo() + cantidadMastiles;
    }

    @Override
    public String toString() {
        return super.toString() + "Velero{" + "cantidadMastiles=" + cantidadMastiles + '}';
    }
    
    

}
