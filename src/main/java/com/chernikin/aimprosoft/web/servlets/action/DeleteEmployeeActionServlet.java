package com.chernikin.aimprosoft.web.servlets.action;

import com.chernikin.aimprosoft.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-employee")
public class DeleteEmployeeActionServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long employeeId = Long.parseLong(req.getParameter("employeeId"));
        final long departmentId = Long.parseLong(req.getParameter("departmentId"));
        employeeService.deleteEmployee(employeeId);
        req.setAttribute("successMessage", "Employee with id: " + employeeId + " delete!");
        resp.sendRedirect("manage-employees-page?departmentId=" + departmentId);

    }
}
