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


@WebServlet("/create-employee-action")
public class CreateEmployeeActionServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Employee employee = extractEmployeeFromRequest(req);
        final Department department = departmentService.getDepartmentById(Long.parseLong(req.getParameter("departmentId")));
        employee.setDepartment(department);
        final long employeeId = employeeService.createEmployee(employee);
        if (employeeId != -1) {
            req.setAttribute("successMessage", "Employee successfully created!");
        } else {
            req.setAttribute("errorMessage", "Creation employee is failed!");
        }
        resp.sendRedirect("manage-employees-page?departmentId=" + department.getId());
    }

    private Employee extractEmployeeFromRequest(HttpServletRequest req) {
        final Employee employee = new Employee();
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setPatronymic(req.getParameter("patronymic"));
        employee.setEmail(req.getParameter("email"));
        employee.setAge(Integer.parseInt(req.getParameter("age")));
        employee.setPhoneNumber(req.getParameter("phoneNumber"));
        try {
            employee.setEmploymentDate(simpleDateFormat.parse(req.getParameter("employmentDate")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
