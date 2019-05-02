package com.chernikin.aimprosoft.web.servlets.page;

import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.service.DepartmentService;
import com.chernikin.aimprosoft.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/create-employee-page")
public class CreateEmployeePageServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Department> allDepartments = departmentService.getAllDepartments();
        req.setAttribute("allDepartments", allDepartments);
        req.getRequestDispatcher("create-department-page.jsp").forward(req, resp);

    }
}
