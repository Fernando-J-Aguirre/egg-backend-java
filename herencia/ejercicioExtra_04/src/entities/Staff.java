package entities;

import enumerators.Area;
import enumerators.MaritalStatus;

public final class Staff extends Employee {
    
    protected Area area;

    public Staff(String name, String lastName, String id, MaritalStatus maritalStatus, int year, int office,
            Area area) {
        super(name, lastName, id, maritalStatus, year, office);
        this.area = area;
    }

    public Staff(Area area) {
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "Staff [area=" + area + "]";
    }
    

    
}
