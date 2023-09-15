package entities;

public abstract class Hotel extends Accommodation {
    protected int roomsAmount;
    protected int bedsAmount;
    protected int floorsAmount;
    protected double bedroomPrice;
    protected String gym;
    protected String restaurantName;
    protected int restaurantCapacity;

    public Hotel(String name, String address, String city, String manager, int roomsAmount,
                 int bedsAmount, int floorsAmount,
                 double bedroomPrice, String gym, String restaurantName, int restaurantCapacity) {
        super(name, address, city, manager);
        this.roomsAmount = roomsAmount;
        this.bedsAmount = bedsAmount;
        this.floorsAmount = floorsAmount;
        this.bedroomPrice = bedroomPrice;
        this.gym = gym;
        this.restaurantName = restaurantName;
        this.restaurantCapacity = restaurantCapacity;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public int getBedsAmount() {
        return bedsAmount;
    }

    public void setBedsAmount(int bedsAmount) {
        this.bedsAmount = bedsAmount;
    }

    public int getFloorsAmount() {
        return floorsAmount;
    }

    public void setFloorsAmount(int floorsAmount) {
        this.floorsAmount = floorsAmount;
    }

    public double getBedroomPrice() {
        return bedroomPrice;
    }

    public void setBedroomPrice(double bedroomPrice) {
        this.bedroomPrice = bedroomPrice;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "roomsAmount=" + roomsAmount +
                ", bedsAmount=" + bedsAmount +
                ", floorsAmount=" + floorsAmount +
                ", bedroomPrice=" + bedroomPrice +
                ", gym='" + gym + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantCapacity=" + restaurantCapacity +
                '}';
    }
}

