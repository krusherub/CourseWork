package com.sportevents.Models;

import java.util.Date;

public class Game {
    private Integer gameId;
    private String title;
    private String date;
    private Competition competition;
    private Team team1;
    private Team team2;
    private String result;

    public Game(Integer gameId, String title, String date,Competition competition, Team team1, Team team2, String result) {
        this.gameId = gameId;
        this.title = title;
        this.date = date;
        this.competition = competition;
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
