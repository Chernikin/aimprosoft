package com.chernikin.aimprosoft.service;

import com.chernikin.aimprosoft.database.DatabaseConnectionManager;
import com.chernikin.aimprosoft.database.dao.EmployeeDao;
import com.chernikin.aimprosoft.domain.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class EmployeeService {

    final EmployeeDao employeeDao = new EmployeeDao();

    public long createEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final long employeeId = employeeDao.create(connection, employee);
            connection.commit();
            return employeeId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return -1;
    }

    public Employee getEmployeeById(long id) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return employeeDao.getById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return null;
    }

    public List<Employee> getAllEmployee() {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return employeeDao.getAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return Collections.emptyList();
    }

    public List<Employee> getAllFromDepartment(long departmentId) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return employeeDao.getAllFromDepartment(connection, departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return Collections.emptyList();
    }

    public Employee updateEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final Employee updatedEmployee = employeeDao.update(connection, employee);
            connection.commit();
            return updatedEmployee;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return employee;
    }

    public void deleteEmployee(long id) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            employeeDao.deleteById(connection, id);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
    }

}
