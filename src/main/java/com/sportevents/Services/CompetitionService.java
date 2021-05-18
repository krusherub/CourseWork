package com.sportevents.Services;

import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Collection;
import java.util.Date;


public interface CompetitionService {
    void addCompetition(String title, String result);

    Collection<Competition> getAllCompetitions();

    Competition getCompetitionById(Integer competitionId);

    void addGame(Competition competition, String title, String date, Team team1, Team team2, String result);

    Game getGameById(Integer gameId);

    Collection<Game> getAllGames();

    void updateCompetition(Competition entity, String title, String result);

    void deleteCompetition(Competition entity);

    void updateGame(Game entity, String title, String date, String team1, String team2, String result);

    void deleteGame(Game entity);

    Collection<Competition> findByTeam(String title);


}
