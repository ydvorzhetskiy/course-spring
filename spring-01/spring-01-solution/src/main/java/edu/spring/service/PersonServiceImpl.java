package edu.spring.service;

import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;

public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao dao) {
        this.personDao = dao;
    }

    public Person getByName(String name) {
        return personDao.findByName(name);
    }
}
