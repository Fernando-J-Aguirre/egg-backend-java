package entities;

import enumerators.Department;
import enumerators.MaritalStatus;

public final class Teacher extends Employee {
    
    protected Department department;

    public Teacher(Department department) {
        this.department = department;
    }

    public Teacher(String name, String lastName, String id, MaritalStatus maritalStatus, int year, int office, Department department) {
        super(name, lastName, id, maritalStatus, year, office);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher [department=" + department + "]";
    }


}
