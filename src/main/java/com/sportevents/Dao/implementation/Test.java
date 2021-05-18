package com.sportevents.Dao.implementation;

import com.sportevents.Models.Admin;
import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
    public static void generate(Database database){
        database.competitions.clear();
        database.admins.clear();
        database.games.clear();

        Admin admin = new Admin(1,"Sasha", "sasha", "123123");

        database.admins.put(1,admin);

        Competition competition1 = new Competition(1, "Tournament 1", "Russia");
        Competition competition2 = new Competition(2, "Tournament 2", "Ukraine");
        Competition competition3 = new Competition(3, "Tournament 3", "Ukraine");
        List<Competition> competitions = Arrays.asList(competition1,competition2,competition3);
        competitions.forEach(competition -> database.competitions.put(competition.getCompId(), competition));


        Game game1 = new Game(1, "Отборочный тур", "14/05/21",competition1,new Team("Russia"), new Team("Ukraine"), "3-2");
        Game game2 = new Game(2, "Отборочный тур", "16/05/21",competition2,new Team("Spain"), new Team("Ukraine"), "1-1");
        Game game3 = new Game(3, "Отборочный тур", "18/05/21",competition3,new Team("Germany"), new Team("Ukraine"), "0-5");
        competition1.getGames().add(game1);
        competition2.getGames().add(game2);
        competition3.getGames().add(game3);

        competition1.getTeams().add(game1.getTeam1());
        competition1.getTeams().add(game1.getTeam2());

        competition2.getTeams().add(game2.getTeam1());
        competition2.getTeams().add(game2.getTeam2());

        competition3.getTeams().add(game3.getTeam1());
        competition3.getTeams().add(game3.getTeam2());

        List<Game> games = Arrays.asList(game1,game2,game3);
        games.forEach(game -> database.games.put(game.getGameId(), game));







    }
}
