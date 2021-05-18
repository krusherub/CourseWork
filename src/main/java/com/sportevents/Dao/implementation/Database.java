package com.sportevents.Dao.implementation;

import com.sportevents.Dao.DaoFactory;
import com.sportevents.Models.Admin;
import com.sportevents.Models.Competition;
import com.sportevents.Models.Game;
import com.sportevents.Models.Team;

import java.util.Map;
import java.util.TreeMap;

public class Database {
    Map<Integer, Admin> admins;
    Map<Integer, Competition> competitions;
    Map<Integer, Game> games;

    public Database() {

        admins = new TreeMap<>();
        competitions = new TreeMap<>();
        games = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new DaoFactoryImpl(this);
    }

}
