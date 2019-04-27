package com.chernikin.aimprosoft.service;

import com.chernikin.aimprosoft.database.DatabaseConnectionManager;
import com.chernikin.aimprosoft.database.dao.DepartmentDao;
import com.chernikin.aimprosoft.domain.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDao();

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

}

