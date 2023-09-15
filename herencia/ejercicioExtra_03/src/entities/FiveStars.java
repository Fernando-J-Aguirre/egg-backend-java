package entities;

public final class FiveStars extends Hotel {
    private int conferenceRoomsAmount;
    private int suitesAmount;
    private int limoAmount;

    public FiveStars(String name, String address, String city, String manager, int roomsAmount, int bedsAmount, int floorsAmount, double bedroomPrice, String gym, String restaurantName,
                     int restaurantCapacity, int conferenceRoomsAmount, int suitesAmount, int limoAmount) {
        super(name, address, city, manager, roomsAmount, bedsAmount, floorsAmount, bedroomPrice, gym, restaurantName, restaurantCapacity);
        this.conferenceRoomsAmount = conferenceRoomsAmount;
        this.suitesAmount = suitesAmount;
        this.limoAmount = limoAmount;
    }

    public int getConferenceRoomsAmount() {
        return conferenceRoomsAmount;
    }

    public void setConferenceRoomsAmount(int conferenceRoomsAmount) {
        this.conferenceRoomsAmount = conferenceRoomsAmount;
    }

    public int getSuitesAmount() {
        return suitesAmount;
    }

    public void setSuitesAmount(int suitesAmount) {
        this.suitesAmount = suitesAmount;
    }

    public int getLimoAmount() {
        return limoAmount;
    }

    public void setLimoAmount(int limoAmount) {
        this.limoAmount = limoAmount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "conferenceRoomsAmount=" + conferenceRoomsAmount +
                ", suitesAmount=" + suitesAmount +
                ", limoAmount=" + limoAmount +
                '}';
    }
}

