package com.sportevents.Dao.implementation;

import com.sportevents.Dao.AdminDao;
import com.sportevents.Models.Admin;

public class AdminDaoImpl extends AbstractDaoImpl<Admin> implements AdminDao {
    public AdminDaoImpl(Database database) {
        super(database.admins, Admin::getAdminId, Admin::setAdminId, database);
    }

    @Override
    public Admin getByLogin(String login) {
        return findAll().stream()
                .filter(o -> o.getLogin().equals(login) )
                .findFirst()
                .orElse(null);
    }
}
