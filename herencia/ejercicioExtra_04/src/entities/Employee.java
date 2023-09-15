package entities;

import enumerators.MaritalStatus;

public abstract class Employee extends Person {
    
    protected int year;
    protected int office;
    
    public Employee(String name, String lastName, String id, MaritalStatus maritalStatus,  int year, int office) {
        super(name, lastName, id, maritalStatus);
        this.year = year;
        this.office = office;
    }

    public Employee() {
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getOffice() {
        return office;
    }
    public void setOffice(int office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return super.toString() + "[year=" + year + ", office=" + office + "]";
    }
    
}
