package com.chernikin.aimprosoft.database.dao;

import com.chernikin.aimprosoft.database.DatabaseConnectionManager;
import com.chernikin.aimprosoft.domain.Department;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class DepartmentDaoTest {

    @Ignore
    @Test
    public void returnDepartmentIdIfDepartmentSuccessfullySavedInDatabase() throws SQLException {
        final DepartmentDao departmentDao = new DepartmentDao();
        final Department department = new Department();
        department.setDepartmentName("TestDep1");
        department.setComments("----");
        final Connection connection = DatabaseConnectionManager.getConnection();
        final long i = departmentDao.create(connection, department);
        DatabaseConnectionManager.closeConnection(connection);
        assertTrue (i > 1);
    }


    @Ignore
    @Test
    public void returnNullIfDepartmentDataDelete() throws SQLException {
        final DepartmentDao departmentDao = new DepartmentDao();
        final Connection connection = DatabaseConnectionManager.getConnection();
        departmentDao.deleteById(connection, 5);
        DatabaseConnectionManager.closeConnection(connection);
        System.out.println("Delete");
    }
}
