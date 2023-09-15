package entities;

public class YateDeLujo extends BarcosAMotor {

    private int numCamarotes;

    public YateDeLujo(int numCamarotes, int potencia, String matricula, double eslora, int anioFabricacion) {
        super(potencia, matricula, eslora, anioFabricacion);
        this.numCamarotes = numCamarotes;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + numCamarotes;
    }

    @Override
    public String toString() {
        return super.toString() + "YateDeLujo{" + "numCamarotes=" + numCamarotes + '}';
    }

}
