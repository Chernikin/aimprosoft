package com.chernikin.aimprosoft.web.servlets.page;

import com.chernikin.aimprosoft.domain.Employee;
import com.chernikin.aimprosoft.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/manage-employees-page")
public class ManageEmployeesPageServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long departmentId = Long.parseLong(req.getParameter("departmentId"));
        final List<Employee> allEmployeesFromDepartment = employeeService.getAllFromDepartment(departmentId);
        req.setAttribute("allEmployeesFromDepartment", allEmployeesFromDepartment);
        req.setAttribute("departmentId", departmentId);
        req.getRequestDispatcher("manage-employees-page.jsp").forward(req, resp);
    }
}

