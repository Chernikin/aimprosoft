package com.chernikin.aimprosoft.web.servlets;

import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.domain.Employee;
import com.chernikin.aimprosoft.service.DepartmentService;
import com.chernikin.aimprosoft.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/link-to-update-employee")
public class LinkToUpdateEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long employeeId = Long.parseLong(req.getParameter("employeeId"));
        final Employee employeeById = employeeService.getEmployeeById(employeeId);
        req.setAttribute("employee", employeeById);
        final List<Department> allDepartments = departmentService.getAllDepartments();
        req.setAttribute("allDepartments", allDepartments);
        req.getRequestDispatcher("update-employee-page.jsp").forward(req, resp);
    }
}
