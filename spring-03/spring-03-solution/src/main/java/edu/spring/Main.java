package edu.spring;

import edu.spring.dao.PersonDao;
import edu.spring.dao.PersonDaoSimple;
import org.springframework.context.annotation.*;
import edu.spring.domain.Person;
import edu.spring.service.PersonService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Locale;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Main {

    private static class LoggingProxyHandler<T> implements InvocationHandler {

        private final T original;

        public LoggingProxyHandler(T original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Вызывается метод " + method.getName());
            String uppercased = ((String) args[0]).toUpperCase(Locale.ROOT);
            Object[] newArgs = new Object[]{uppercased};
            Object result = method.invoke(original, newArgs);
            return new Person("Maria", 33);
        }
    }

    public static void main(String[] args) {

        PersonDao personDaoSimple = new PersonDaoSimple();
        PersonDao personDao = (PersonDao)
                Proxy.newProxyInstance(Main.class.getClassLoader(),
                        new Class[]{PersonDao.class},
                        new LoggingProxyHandler<PersonDao>(personDaoSimple));

        personDao.findByName("Ivan");
//
//
//
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(Main.class);
//
//        PersonService service = context.getBean(PersonService.class);
//
//        Person ivan = service.getByName("Ivan");
//        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
