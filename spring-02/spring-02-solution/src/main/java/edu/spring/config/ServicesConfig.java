package edu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.spring.dao.PersonDao;
import edu.spring.service.PersonService;
import edu.spring.service.PersonServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@PropertySource("./app.properties")
@Configuration
public class ServicesConfig {

    @Primary
    @Bean
    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
