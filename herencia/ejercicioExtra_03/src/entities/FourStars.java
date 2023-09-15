package entities;

public final class FourStars extends Hotel {

    public FourStars(String name, String address, String city, String manager, int roomsAmount,
            int bedsAmount, int floorsAmount, double bedroomPrice, String gym, String restaurantName,
            int restaurantCapacity) {
        super(name, address, city, manager, roomsAmount, bedsAmount, floorsAmount, bedroomPrice,
                gym, restaurantName, restaurantCapacity);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
