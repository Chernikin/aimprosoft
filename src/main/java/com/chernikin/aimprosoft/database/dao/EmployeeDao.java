package com.chernikin.aimprosoft.database.dao;

import com.chernikin.aimprosoft.database.JdbcTemplate;
import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDao implements GenericDao<Employee> {

    final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public long create(Connection connection, Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date, dismissal_date, department_id) VALUES (?,?,?,?,?,?,?,?)";
        final long idDepartment = employee.getDepartment().getId();
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, (Date) employee.getEmploymentDate());
            preparedStatement.setDate(7, (Date) employee.getDismissalDate());
            preparedStatement.setLong(8, idDepartment);
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Employee getById(Connection connection, long id) {
        String sql = "SELECT * FROM employees join departments on employees.department_id = departments.id WHERE id = ?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAll(Connection connection) {
        String sql = "SELECT * FROM employees join departments on employees.department_id = departments.id";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(extractEmployeeFromResultSet(resultSet));
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Employee update(Connection connection, Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, patronymic = ?, email = ?, phone_number = ?, employment_date = ?" +
                " dismissal_date = ?, department_id = ? WHERE id = ?";
        final long idDepartment = employee.getDepartment().getId();
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, (Date) employee.getEmploymentDate());
            preparedStatement.setDate(7, (Date) employee.getDismissalDate());
            preparedStatement.setLong(8, idDepartment);
            preparedStatement.setLong(9, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void deleteById(Connection connection, long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.deleteById(connection, sql, id);
    }


    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPatronymic(resultSet.getString("patronymic"));
        employee.setEmail(resultSet.getString("email"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setEmploymentDate(resultSet.getDate("employment_date"));
        employee.setDismissalDate(resultSet.getDate("dismissal_date"));
        final Department department = new Department();
        department.setId(resultSet.getLong("department_id"));
        department.setDepartmentName(resultSet.getString("department_name"));
        department.setComments(resultSet.getString("comments"));
        employee.setDepartment(department);
        return employee;
    }
}
