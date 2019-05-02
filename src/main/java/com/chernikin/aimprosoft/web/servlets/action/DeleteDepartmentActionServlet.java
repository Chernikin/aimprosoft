package com.chernikin.aimprosoft.web.servlets.action;

import com.chernikin.aimprosoft.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-department")
public class DeleteDepartmentActionServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long departmentId = Long.parseLong(req.getParameter("id"));
        departmentService.deleteDepartmentById(departmentId);
        req.setAttribute("successMessage", "Department with id: " + departmentId + " delete!");
        req.getRequestDispatcher("manage-departments-page").forward(req, resp);
    }
}
