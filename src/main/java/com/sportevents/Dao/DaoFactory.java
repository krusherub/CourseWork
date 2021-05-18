package com.sportevents.Dao;

import com.sportevents.Models.Admin;

public interface DaoFactory {
    GameDao getGameDao();

    CompetitionDao getCompetitionDao();

    AdminDao getAdminDao();

}
