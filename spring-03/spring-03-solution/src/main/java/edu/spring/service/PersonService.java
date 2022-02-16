package edu.spring.service;

import edu.spring.logging.Loggable;
import org.springframework.stereotype.Service;
import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;

@Service
public class PersonService {

    private final PersonDao dao;

    public PersonService(PersonDao dao) {
        this.dao = dao;
    }

    @Loggable
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
