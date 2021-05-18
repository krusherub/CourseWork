package com.sportevents.Controllers;

import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCompetitionServlet", value = "/AddCompetitionServlet")
public class AddCompetitionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            request.getRequestDispatcher("Admin.jsp").forward(request,response);
            return;
        }
        ServletContext context = getServletContext();
        CompetitionService competitionService = (CompetitionService) context.getAttribute("competitionService");
        String competitionName = request.getParameter("competitionName");
        competitionService.addCompetition(competitionName,"TBA");
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
