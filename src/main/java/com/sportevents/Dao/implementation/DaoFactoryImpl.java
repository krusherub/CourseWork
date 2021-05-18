package com.sportevents.Dao.implementation;

import com.sportevents.Dao.*;
import com.sportevents.Models.Admin;

public class DaoFactoryImpl implements DaoFactory {
    Database db;
    AdminDao adminDao;
    GameDao gameDao;
    CompetitionDao competitionDao;
    public DaoFactoryImpl(Database db) {
        this.db = db;

        adminDao = new AdminDaoImpl(db);
        gameDao = new GameDaoImpl(db);
        competitionDao = new CompetitionDaoImpl(db);
    }

    @Override
    public GameDao getGameDao() {
        return gameDao;
    }

    @Override
    public CompetitionDao getCompetitionDao() {
        return competitionDao;
    }

    @Override
    public AdminDao getAdminDao() {
        return adminDao;
    }

}
