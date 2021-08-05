package edu.spring.repostory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.spring.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class PersonRepositoryJpa implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }
}
