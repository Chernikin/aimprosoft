package com.chernikin.aimprosoft.web.servlets;

import com.chernikin.aimprosoft.domain.Department;
import com.chernikin.aimprosoft.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/link-to-update-department")
public class LinkToUpdateDepartmentServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long departmentId = Long.parseLong(req.getParameter("id"));
        final Department departmentById = departmentService.getDepartmentById(departmentId);
        req.setAttribute("department", departmentById);
        req.getRequestDispatcher("update-department-page.jsp").forward(req, resp);
    }
}
