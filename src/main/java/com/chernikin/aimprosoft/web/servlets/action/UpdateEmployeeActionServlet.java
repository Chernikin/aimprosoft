package com.chernikin.aimprosoft.web.servlets.action;

import com.chernikin.aimprosoft.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/update-employee-action")
public class UpdateEmployeeActionServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
