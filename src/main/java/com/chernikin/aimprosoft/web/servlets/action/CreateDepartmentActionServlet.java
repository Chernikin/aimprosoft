package com.chernikin.aimprosoft.web.servlets.action;

import com.chernikin.aimprosoft.DepartmentValidator;
import com.chernikin.aimprosoft.ValidationResult;
import com.chernikin.aimprosoft.Validator;
import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-department-action")
public class CreateDepartmentActionServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();
    private Validator<Department> validator = new DepartmentValidator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final Department department = getDepartment(req);
        final ValidationResult validationResult = validator.validate(department);

        if (validationResult.hasErrors()) {
            processError(req, resp, department, validationResult);
            return;
        }
        createDepartment(req, resp, department);
    }

    private void processError(HttpServletRequest req, HttpServletResponse resp, Department department, ValidationResult validationResult) throws ServletException, IOException {
        req.setAttribute("errors", validationResult.getErrorMessages());
        req.setAttribute("incorrectDepartmentData", department);
        req.getRequestDispatcher("create-department-page.jsp").forward(req, resp);
    }

    private void createDepartment(HttpServletRequest req, HttpServletResponse resp, Department department) throws IOException {
        departmentService.createDepartment(department);
        req.setAttribute("successMessage", "Department successfully created!");
        resp.sendRedirect("manage-departments-page");
    }

    private Department getDepartment(HttpServletRequest req) {
        final Department department = new Department();
        department.setDepartmentName(req.getParameter("departmentName"));
        department.setComments(req.getParameter("comments"));
        return department;
    }
}
