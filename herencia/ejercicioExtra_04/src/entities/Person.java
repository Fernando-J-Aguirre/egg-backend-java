package entities;

import enumerators.MaritalStatus;

public abstract class Person {
    
    protected String name;
    protected String lastName;
    protected String id;
    protected MaritalStatus maritalStatus;

    public Person(String name, String lastName, String id, MaritalStatus maritalStatus) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.maritalStatus = maritalStatus;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", lastName=" + lastName + ", id=" + id + ", maritalStatus=" + maritalStatus
                + "]";
    }


}
