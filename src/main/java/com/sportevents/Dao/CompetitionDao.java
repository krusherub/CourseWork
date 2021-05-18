package com.sportevents.Dao;

import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;

import java.util.Collection;

public interface CompetitionDao extends AbstractDao<Competition>{
    Collection<Competition> findByTeam(String title);
    void addCompetition(String title, String result);
}
