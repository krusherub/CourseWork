package com.sportevents.Controllers;

import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteGameServlet", value = "/DeleteGameServlet")
public class DeleteGameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getSession().getAttribute("admin") == null){
            request.getRequestDispatcher("Admin.jsp").forward(request,response);
            return;
        }
        ServletContext context = getServletContext();
        CompetitionService competitionService = (CompetitionService) context.getAttribute("competitionService");
        Integer id = Integer.parseInt(request.getParameter("id"));
        competitionService.deleteGame(competitionService.getGameById(id));
        request.getRequestDispatcher("Admin.jsp").forward(request,response);
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

