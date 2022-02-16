package edu.spring.dao;

import edu.spring.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import edu.spring.domain.Person;

import java.util.Locale;

@Repository
public class PersonDao {

    private final PersonDao self;

    public PersonDao(@Lazy PersonDao self) {
        this.self = self;
    }

    @Loggable("Метод вызывается: %s")
    public Person findByName(String name) {
        System.out.println("Сам метод findByName");
        if (("" + name.charAt(0)).toUpperCase(Locale.ROOT)
                .equals(("" + name.charAt(0)))) {
            return self.findByName(name.toLowerCase(Locale.ROOT));
        }
        return new Person(name, 18);
    }
}
