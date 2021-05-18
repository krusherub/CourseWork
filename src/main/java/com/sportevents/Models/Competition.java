package com.sportevents.Models;

import java.util.*;

public class Competition {
    private Integer compId;
    private String title;
    private List<Game> games;
    private Set<Team> teams;
    private String result;

    public Competition(Integer compId, String title, String result) {
        this.compId = compId;
        this.title = title;
        this.result = result;
        games = new ArrayList<>();
        teams = new TreeSet<>((o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle()));
    }

    public Integer getCompId() {
        return compId;
    }

    public String getTitle() {
        return title;
    }

    public List<Game> getGames() {
        return games;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setCompId(Integer compId) { this.compId = compId; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNumberOfGames() {
        return games.size();
    }

    public int getNumberOfTeams() {
        return teams.size();
    }

}
