package edu.spring.service;

import org.springframework.stereotype.Service;
import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
