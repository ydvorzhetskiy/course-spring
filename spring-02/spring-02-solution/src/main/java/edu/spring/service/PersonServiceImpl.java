package edu.spring.service;

import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao2) {
        this.dao = personDao2;
    }

    public Person getByName(String name) {
        if (this.dao != null)
            return dao.findByName(name);
        return null;
    }
}
