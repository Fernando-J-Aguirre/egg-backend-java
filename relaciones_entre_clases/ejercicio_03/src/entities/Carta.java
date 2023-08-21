package entities;

public class Carta {

    private int num;
    private Palo palo;

    public Carta() {
    }

    public Carta(int num, Palo palo) {
        this.num = num;
        this.palo = palo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return num + " " + palo + "\n";
    }
    
    
    
    
    
}
