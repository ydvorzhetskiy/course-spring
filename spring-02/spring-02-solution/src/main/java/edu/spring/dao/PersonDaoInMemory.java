package edu.spring.dao;

import edu.spring.domain.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// personDaoInMemory
@Repository
public class PersonDaoInMemory implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
