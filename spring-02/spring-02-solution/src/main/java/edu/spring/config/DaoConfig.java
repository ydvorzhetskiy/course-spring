package edu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.spring.dao.PersonDao;
import edu.spring.dao.PersonDaoSimple;

@Configuration
public class DaoConfig {

    @Bean
    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
