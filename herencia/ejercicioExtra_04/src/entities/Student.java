package entities;

import enumerators.MaritalStatus;

public final class Student extends Person{
    
    protected String course;

    public Student(String name, String lastName, String id, MaritalStatus maritalStatus, String course) {
        super(name, lastName, id, maritalStatus);
        this.course = course;
    }

    public Student(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + "Student [course=" + course + "]";
    }

    

}
