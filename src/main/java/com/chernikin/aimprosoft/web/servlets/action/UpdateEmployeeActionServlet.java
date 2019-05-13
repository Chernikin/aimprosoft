package com.chernikin.aimprosoft.web.servlets.action;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/update-employee-action")
public class UpdateEmployeeActionServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long employeeId = Long.parseLong(req.getParameter("id"));
        final long departmentId = Long.parseLong(req.getParameter("departmentId"));
        final Department departmentById = departmentService.getDepartmentById(departmentId);
        final Employee employeeById = employeeService.getEmployeeById(employeeId);
        employeeById.setFirstName(req.getParameter("firstName"));
        employeeById.setLastName(req.getParameter("lastName"));
        employeeById.setPatronymic(req.getParameter("patronymic"));
        employeeById.setEmail(req.getParameter("email"));
        employeeById.setAge(Integer.parseInt(req.getParameter("age")));
        employeeById.setPhoneNumber(req.getParameter("phoneNumber"));
        try {
            employeeById.setEmploymentDate(simpleDateFormat.parse(req.getParameter("employmentDate")));
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        employeeById.setDepartment(departmentById);
        employeeService.updateEmployee(employeeById);
        resp.sendRedirect("manage-employees-page?departmentId=" + departmentId);
    }
}
