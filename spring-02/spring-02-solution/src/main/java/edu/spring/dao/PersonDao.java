package edu.spring.dao;

import edu.spring.domain.Person;

public interface PersonDao {

    public static final String PRIMARY_BEAN_NAME = "personDao-default-bean";

    Person findByName(String name);
}
