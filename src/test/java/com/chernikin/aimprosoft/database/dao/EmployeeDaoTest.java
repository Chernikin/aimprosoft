package com.chernikin.aimprosoft.database.dao;

import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.domain.Employee;
import com.chernikin.aimprosoft.service.DepartmentService;
import com.chernikin.aimprosoft.service.EmployeeService;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class EmployeeDaoTest {

    @Ignore
    @Test
    public void returnEmployeeIdIfEmployeeSuccessfullySavedInDatabase(){
        final EmployeeService employeeService = new EmployeeService();
        final Employee employee = new Employee();
        final DepartmentService departmentService = new DepartmentService();
        employee.setFirstName("Test");
        employee.setLastName("Test");
        employee.setPatronymic("test");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("Test");
        final Department departmentById = departmentService.getDepartmentById(1);
        employee.setDepartment(departmentById);
        final long i = employeeService.createEmployee(employee);
        assertTrue(i > 1);
    }

    @Ignore
    @Test
    public void returnEmployeeIfEmployeeUpdate(){
        final EmployeeService employeeService = new EmployeeService();
        final Employee employeeById = employeeService.getEmployeeById(6);
        employeeById.setFirstName("Test Update");
        final Employee employee = employeeService.updateEmployee(employeeById);
        assertNotNull(employee);
    }

    @Ignore
    @Test
    public void returnNullIfEmployeeDataDelete(){
        final EmployeeService employeeService = new EmployeeService();
        employeeService.deleteEmployee(6);
    }
}
