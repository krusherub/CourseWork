package com.sportevents.Dao.implementation;

import com.sportevents.Dao.CompetitionDao;
import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class CompetitionDaoImpl extends AbstractDaoImpl<Competition> implements CompetitionDao {
    public CompetitionDaoImpl(Database database) {
        super(database.competitions, Competition::getCompId, Competition::setCompId, database);
    }

    @Override
    public Collection<Competition> findByTeam(String title) {
        ArrayList<Competition> competitions = new ArrayList<>();
        for (Competition competition : database.competitions.values()) {
            for (Game game : competition.getGames()) {
                if(game.getTeam1().getTitle().toLowerCase().contains(title.toLowerCase()) || game.getTeam2().getTitle().toLowerCase().contains(title.toLowerCase()))
                    competitions.add(competition);
                break;
            }
        }
        return competitions;
    }

    @Override
    public void addCompetition(String title, String result) {
        Competition competition = new Competition(-1, title, result);

        this.insert(competition);
    }

}
