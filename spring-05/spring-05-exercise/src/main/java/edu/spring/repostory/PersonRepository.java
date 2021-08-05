package edu.spring.repostory;

import edu.spring.domain.Person;

public interface PersonRepository {

    //void insert(Person p);

    Person getById(int id);

    //Person getFirst();

    //List<Person> getAll();

    //Person getByName(String name);
}
