package com.sportevents.Dao.implementation;

import com.sportevents.Dao.GameDao;
import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Date;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class GameDaoImpl extends AbstractDaoImpl<Game> implements GameDao {
    public GameDaoImpl(Database database) {
        super(database.games, Game::getGameId, Game::setGameId, database);
    }

    @Override
    public void addGame(Competition competition, String title, String date, Team team1, Team team2, String result) {
        Game game = new Game(-1, title, date, competition, team1, team2, result);

        this.insert(game);
        competition.getGames().add(game);
        competition.getTeams().add(game.getTeam1());
        competition.getTeams().add(game.getTeam2());
    }
}
