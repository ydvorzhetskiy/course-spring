package edu.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import edu.spring.repostory.PersonRepository;

public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    // TODO: add code here
}
