package com.example.web.Service.Interface;

import java.util.List;

import com.example.web.Model.Person;

public interface PersonServiceInterface {
    List <Person> getAllPerson();
    void savePerson(Person person);
    Person getPersonById(long id);
    void deletePersonById(long id);
}
