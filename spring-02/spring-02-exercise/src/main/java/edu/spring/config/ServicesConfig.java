package edu.spring.config;

import edu.spring.dao.PersonDao;
import edu.spring.service.PersonService;
import edu.spring.service.PersonServiceImpl;

public class ServicesConfig {

    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
