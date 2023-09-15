package entities;

public final class Camping extends AlternativeAcc{
    private int maxTent;
    private int bathroomsAmount;
    private boolean restaurant;

    public Camping(String name, String address, String city, String manager, boolean privateAcc,
                   double squareMts, int maxTent, int bathroomsAmount, boolean restaurant) {
        super(name, address, city, manager, privateAcc, squareMts);
        this.maxTent = maxTent;
        this.bathroomsAmount = bathroomsAmount;
        this.restaurant = restaurant;
    }

    public int getMaxTent() {
        return maxTent;
    }

    public void setMaxTent(int maxTent) {
        this.maxTent = maxTent;
    }

    public int getBathroomsAmount() {
        return bathroomsAmount;
    }

    public void setBathroomsAmount(int bathroomsAmount) {
        this.bathroomsAmount = bathroomsAmount;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return super.toString() +
                "maxTent=" + maxTent +
                ", bathroomsAmount=" + bathroomsAmount +
                ", restaurant=" + restaurant +
                '}';
    }
}


