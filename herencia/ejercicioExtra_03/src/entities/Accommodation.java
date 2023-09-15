package entities;

public abstract class Accommodation {
    protected String name;
    protected String address;
    protected String city;
    protected String manager;

    public Accommodation(String name, String address, String city, String manager) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", manager='" + manager ;
    }
}
