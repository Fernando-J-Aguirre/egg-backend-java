package services;

import entities.Teacher;
import enumerators.Department;

public class TeacherService extends EmployeeService {

    public void changeDepartment(Teacher teacher, Department department) {
        teacher.setDepartment(department);
    }
    
}
