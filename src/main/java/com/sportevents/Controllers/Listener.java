package com.sportevents.Controllers;

import com.sportevents.Dao.DaoFactory;
import com.sportevents.Dao.implementation.Database;
import com.sportevents.Dao.implementation.Test;
import com.sportevents.Services.AdminService;
import com.sportevents.Services.AdminServiceImpl;
import com.sportevents.Services.CompetitionService;
import com.sportevents.Services.CompetitionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Database database = new Database();

        Test.generate(database);

        DaoFactory daoFactory = database.getDaoFactory();

        AdminService adminService = new AdminServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("adminService", adminService);

        CompetitionService competitionService = new CompetitionServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("competitionService",competitionService);

        sce.getServletContext().setAttribute("allCompetitions",competitionService.getAllCompetitions());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
