package edu.spring.dao;

import edu.spring.domain.Department;
import edu.spring.domain.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getByDepartment(Department department);
}
