package com.sportevents.Controllers;

import com.sportevents.Models.Competition;
import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "CompetitionServlet", value = "/CompetitionServlet")
public class CompetitionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        ServletContext context = getServletContext();
        CompetitionService competitionService = (CompetitionService) context.getAttribute("competitionService");
        request.setAttribute("comp",competitionService.getCompetitionById(id));
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
