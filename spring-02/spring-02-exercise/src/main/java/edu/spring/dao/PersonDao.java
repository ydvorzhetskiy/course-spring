package edu.spring.dao;

import edu.spring.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
