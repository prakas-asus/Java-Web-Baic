package com.example.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.web.Model.Person;
import com.example.web.Service.Implementation.PersonServiceImplementation;

@Controller
public class PersonController {

    @Autowired
    private PersonServiceImplementation personServiceImplementation;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listPerson", personServiceImplementation.getAllPerson());
        return "person/index";
    }
    
    @GetMapping("/create")
    public String create(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/create";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute("person") Person person){
        personServiceImplementation.savePerson(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model){
        Person person = personServiceImplementation.getPersonById(id);
        model.addAttribute("person", person);
        return "person/update";
    }
    
    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable(value = "id") long id){
        this.personServiceImplementation.deletePersonById(id);
        return "redirect:/";
    }
}