package com.sportevents.Services;

import com.sportevents.Dao.DaoFactory;
import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Collection;
import java.util.Date;

public class CompetitionServiceImpl implements  CompetitionService{
    DaoFactory daoFactory;
    public CompetitionServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void addCompetition(String title, String result) {
        daoFactory.getCompetitionDao().addCompetition(title, result);
    }

    @Override
    public Collection<Competition> getAllCompetitions() {
        return daoFactory.getCompetitionDao().findAll();
    }

    @Override
    public Competition getCompetitionById(Integer competitionId) {
        return daoFactory.getCompetitionDao().get(competitionId);
    }

    @Override
    public void addGame(Competition competition, String title, String date, Team team1, Team team2, String result) {
        daoFactory.getGameDao().addGame(competition, title, date, team1, team2, result);
    }
    @Override
    public Game getGameById(Integer id){
        return daoFactory.getGameDao().get(id);
    }

    @Override
    public Collection<Game> getAllGames(){
        return  daoFactory.getGameDao().findAll();
    }

    @Override
    public void updateCompetition(Competition entity, String title, String result){
        entity.setTitle(title);
        entity.setResult(result);
        daoFactory.getCompetitionDao().update(entity);
    }

    @Override
    public void deleteCompetition(Competition entity){
        daoFactory.getCompetitionDao().delete(entity);
    }

    @Override
    public void updateGame(Game entity, String title, String date, String team1, String team2, String result) {
        entity.setTitle(title);
        entity.setResult(result);
        entity.setDate(date);
        entity.getCompetition().getTeams().remove(entity.getTeam1());
        entity.getCompetition().getTeams().remove(entity.getTeam2());
        entity.getTeam1().setTitle(team1);
        entity.getTeam2().setTitle(team2);
        entity.getCompetition().getTeams().add(entity.getTeam1());
        entity.getCompetition().getTeams().add(entity.getTeam2());
        daoFactory.getGameDao().update(entity);
    }

    @Override
    public void deleteGame(Game entity) {
        entity.getCompetition().getGames().remove(entity);
        entity.getCompetition().getTeams().remove(entity.getTeam1());
        entity.getCompetition().getTeams().remove(entity.getTeam2());
        daoFactory.getGameDao().delete(entity);
    }

    @Override
    public Collection<Competition> findByTeam(String title) {
        if(title == null || title.equals(""))
            return getAllCompetitions();
        return  daoFactory.getCompetitionDao().findByTeam(title);
    }

}
