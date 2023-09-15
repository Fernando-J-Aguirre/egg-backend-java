package entities;

public abstract class AlternativeAcc extends Accommodation{
    protected boolean privateAcc;
    protected double squareMts;


    public AlternativeAcc(String name, String address, String city, String manager, boolean privateAcc, double squareMts) {
        super(name, address, city, manager);
        this.privateAcc = privateAcc;
        this.squareMts = squareMts;
    }

    public boolean isPrivateAcc() {
        return privateAcc;
    }

    public void setPrivateAcc(boolean privateAcc) {
        this.privateAcc = privateAcc;
    }

    public double getSquareMts() {
        return squareMts;
    }

    public void setSquareMts(double squareMts) {
        this.squareMts = squareMts;
    }

    @Override
    public String toString() {
        return super.toString() +
                "privateAcc=" + privateAcc +
                ", squareMts=" + squareMts +
                '}';
    }
}

