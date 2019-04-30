package com.chernikin.aimprosoft.service;

import com.chernikin.aimprosoft.database.DatabaseConnectionManager;
import com.chernikin.aimprosoft.database.dao.DepartmentDao;
import com.chernikin.aimprosoft.domain.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDao();

    public long createDepartment(Department department){
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final long departmentId = departmentDao.create(connection, department);
            connection.commit();
            return departmentId;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectionManager.closeConnection(connection);
        }return -1;
    }

    public Department getDepartmentById(long id) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return departmentDao.getById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return null;
    }

    public List<Department> getAllDepartment(){
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return departmentDao.getAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectionManager.closeConnection(connection);
        }return null;
    }

    public Department updateDepartment(Department department){
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final Department updatedDepartment = departmentDao.update(connection, department);
            connection.commit();
            return updatedDepartment;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return department;
    }

    public void deleteDepartmentById(long id){
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            departmentDao.deleteById(connection, id);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
    }

}

