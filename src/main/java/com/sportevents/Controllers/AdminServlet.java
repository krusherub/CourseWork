package com.sportevents.Controllers;

import com.sportevents.Models.Admin;
import com.sportevents.Services.AdminService;
import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        ServletContext context = getServletContext();
        AdminService adminService = (AdminService) context.getAttribute("adminService");

        String login = request.getParameter("username");
        Admin admin = adminService.getByLogin(login);

        if (admin == null) {
            request.setAttribute("message", "Admin with such username doesn't exist");
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
            return;
        }

        String password = request.getParameter("pass");

        if(!adminService.Password(admin, password)){
            request.setAttribute("message", "The password isn't correct. Please, try again..");
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("admin", admin);
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
