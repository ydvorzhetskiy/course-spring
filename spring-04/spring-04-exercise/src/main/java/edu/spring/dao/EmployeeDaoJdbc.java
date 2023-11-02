package edu.spring.dao;

import edu.spring.domain.Department;
import edu.spring.domain.Employee;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class EmployeeDaoJdbc implements EmployeeDao {
    private final JdbcOperations jdbc;

    public EmployeeDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
    }

    @Override
    public List<Employee> getByDepartment(Department department) {
        return jdbc.query("select employee.tabNum, employee.fullName, position.name as position from employee" +
                " inner join position on position.id = employee.positionId " +
                " where position.departmentId = ? order by position.id", new EmployeeMapper(), department.getId());
    }

    private static class EmployeeMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            String tabNum = resultSet.getString("tabNum");
            String fullName = resultSet.getString("fullName");
            String position = resultSet.getString("position");
            return new Employee(tabNum, fullName, position);
        }
    }
}
