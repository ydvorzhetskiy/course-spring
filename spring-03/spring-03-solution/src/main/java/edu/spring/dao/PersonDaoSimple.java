package edu.spring.dao;

import org.springframework.stereotype.Repository;
import edu.spring.domain.Person;

@Repository
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        System.out.println("Метод вызван с именем " + name);
        return new Person(name, 18);
    }
}
