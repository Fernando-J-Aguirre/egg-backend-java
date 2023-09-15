package services;

import enumerators.MaritalStatus;
import entities.Person;

public class PersonService {
    
    public void changeMaritalStatus(Person person, MaritalStatus maritalStatus) {
        person.setMaritalStatus(maritalStatus);
    }
    
}
