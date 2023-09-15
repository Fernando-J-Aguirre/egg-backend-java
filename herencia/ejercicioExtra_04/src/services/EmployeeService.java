package services;

import entities.Employee;

public class EmployeeService extends PersonService {
    
    public void changeOffice(Employee employee, int office) {
        employee.setOffice(office);
    }
}
