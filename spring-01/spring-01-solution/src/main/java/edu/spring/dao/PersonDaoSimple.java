package edu.spring.dao;

import edu.spring.domain.Person;
import edu.spring.service.PersonService;

public class PersonDaoSimple implements PersonDao {

    public PersonDaoSimple(PersonService service) {
        service.getByName("Ivan");
    }

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
