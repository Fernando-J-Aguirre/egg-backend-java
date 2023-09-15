
package ejercicioextra_04;

import entities.Staff;
import services.StaffService;

public class EjercicioExtra_04 {

    public static void main(String[] args) {
        
        Staff staff = new Staff("Juan", "Perez", "123456789", enumerators.MaritalStatus.SINGLE, 2010, 1, enumerators.Area.ADMISSIONS);
        StaffService ss = new StaffService();


    }

}
