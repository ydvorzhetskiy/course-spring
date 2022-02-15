package edu.spring.dao;

import edu.spring.domain.Person;
import org.springframework.stereotype.Repository;

// personDao2
@Repository
public class PersonDao2 implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
