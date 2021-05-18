package com.sportevents.Controllers;

import com.sportevents.Models.Game;
import com.sportevents.Services.CompetitionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UpdateGameServlet", value = "/UpdateGameServlet")
public class UpdateGameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("admin") == null){
            request.getRequestDispatcher("Admin.jsp").forward(request,response);
            return;
        }
        ServletContext context = getServletContext();
        CompetitionService competitionService = (CompetitionService) context.getAttribute("competitionService");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String gameName = request.getParameter("gameName");
        String gameDate = request.getParameter("gameDate");
        String team1 = request.getParameter("team1");
        String result = request.getParameter("result");
        String team2 = request.getParameter("team2");
        Game game = competitionService.getGameById(id);
        competitionService.updateGame(game,gameName,gameDate,team1,team2,result);
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
