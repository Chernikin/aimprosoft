package com.chernikin.aimprosoft.database.dao;

import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.service.DepartmentService;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DepartmentDaoTest {

    @Ignore
    @Test
    public void returnDepartmentIdIfDepartmentSuccessfullySavedInDatabase() {
        final DepartmentService departmentService = new DepartmentService();
        final Department department = new Department();
        department.setDepartmentName("TestService");
        department.setComments("Hello");
        final long i = departmentService.createDepartment(department);
        assertTrue(i > 1);
    }


    @Ignore
    @Test
    public void returnNullIfDepartmentDataDelete() {
        final DepartmentService departmentService = new DepartmentService();
        departmentService.deleteDepartmentById(4);
    }

    @Ignore
    @Test
    public void returnDepartmentIfDepartmentUpdate(){
        final DepartmentService departmentService = new DepartmentService();
        final Department departmentById = departmentService.getDepartmentById(4);
        departmentById.setDepartmentName("Updated Dep");
        final Department department = departmentService.updateDepartment(departmentById);

        assertNotNull(department);

    }

}
