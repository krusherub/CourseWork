package com.sportevents.Controllers;

import com.sportevents.Models.Competition;
import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FindServlet", value = "/FindServlet")
public class FindServlet extends HttpServlet {

    protected  void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        ServletContext context = getServletContext();
        CompetitionService competitionService = (CompetitionService) context.getAttribute("competitionService");
        Collection<Competition> competitionsByFind = competitionService.findByTeam(title);
        request.setAttribute("allCompetitions",competitionsByFind);
        request.setAttribute("title",title);
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
