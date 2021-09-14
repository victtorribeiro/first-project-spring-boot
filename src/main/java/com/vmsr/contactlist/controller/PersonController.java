package com.vmsr.contactlist.controller;

import com.vmsr.contactlist.model.Person;
import com.vmsr.contactlist.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository repository;



    @GetMapping(path = "/filterbyid/{id}")
    public ResponseEntity consultID(@PathVariable Long id){

        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/filterbyemail/{email}")
    public ResponseEntity<List<Person>> findPersonByEmail(@PathVariable String email){

        List<Person> person = repository.findByEmail(email);

        return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/filterbyname/{name}")
    public ResponseEntity<List<Person>> findPersonByName(@PathVariable String name) throws Exception{

        List<Person> person = repository.findByName(name);

        return new ResponseEntity<List<Person>>(person, HttpStatus.OK);


    }

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        repository.save(person);
        return person;
    }


}
