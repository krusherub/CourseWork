package com.sportevents.Dao;

import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Date;

public interface GameDao extends AbstractDao<Game>{
    void addGame(Competition competition, String title, String date, Team team1, Team team2, String result);

}
