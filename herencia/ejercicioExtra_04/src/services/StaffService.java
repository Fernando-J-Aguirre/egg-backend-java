package services;

import entities.Staff;
import enumerators.Area;

public class StaffService {
    
    public void changeArea(Staff staff, Area area) {
        staff.setArea(area);
    }

}
