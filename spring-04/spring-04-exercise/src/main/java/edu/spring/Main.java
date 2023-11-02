package edu.spring;

import edu.spring.dao.DepartmentDao;
import edu.spring.dao.EmployeeDao;
import edu.spring.domain.Department;
import edu.spring.domain.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);

        DepartmentDao departmentDao = context.getBean(DepartmentDao.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        List<Department> departments = departmentDao.getAll();
        departments.forEach(dep -> {
            System.out.println("============================");
            System.out.println(dep.getName());
            System.out.println("============================");
            List<Employee> emps = employeeDao.getByDepartment(dep);
            emps.forEach(emp -> {
                System.out.println(emp.getTabNum() + " " + emp.getPosition() + " " + emp.getFullName());
            });
        });
    }
}
