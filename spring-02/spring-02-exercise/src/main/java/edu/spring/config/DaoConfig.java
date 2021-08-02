package edu.spring.config;

import edu.spring.dao.PersonDao;
import edu.spring.dao.PersonDaoSimple;

public class DaoConfig {

    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
