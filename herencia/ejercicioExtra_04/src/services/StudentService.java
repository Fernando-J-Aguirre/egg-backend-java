package services;

import entities.Student;

public class StudentService extends PersonService {
    
    public void updateCourse(Student student, String course) {
        student.setCourse(course);
    }

}
