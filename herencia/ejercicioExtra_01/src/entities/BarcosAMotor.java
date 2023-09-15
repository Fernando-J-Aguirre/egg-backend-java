package entities;

public class BarcosAMotor extends Barco {

    protected int potencia;

    public BarcosAMotor(int potencia, String matricula, double eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + potencia;
    }

    @Override
    public String toString() {
        return super.toString() + "BarcosAMotor{" + "potencia=" + potencia + '}';
    }

}
