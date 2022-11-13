package com.example.web.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.Model.Person;
import com.example.web.Repository.PersonRepository;
import com.example.web.Service.Interface.PersonServiceInterface;

@Service
public class PersonServiceImplementation implements PersonServiceInterface{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        // TODO Auto-generated method stub
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        // TODO Auto-generated method stub
        this.personRepository.save(person);
    }
    
    @Override
    public Person getPersonById(long id) {
        // TODO Auto-generated method stub
        Optional <Person> optional = personRepository.findById(id);
        Person person = null;
        if (optional.isPresent()) {
            person = optional.get();
        } else {
            throw new RuntimeException(" Person not found id ::" + id);
        }
        return person;
    }

    @Override
    public void deletePersonById(long id) {
        // TODO Auto-generated method stub
        this.personRepository.deleteById(id);
        
    }
    
}
