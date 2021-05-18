package com.sportevents.Services;

import com.sportevents.Dao.DaoFactory;
import com.sportevents.Models.Admin;

public class AdminServiceImpl implements AdminService{
    DaoFactory daoFactory;

    public AdminServiceImpl(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public Admin getByLogin(String login) {
        return daoFactory.getAdminDao().getByLogin(login);
    }

    @Override
    public boolean Password(Admin admin, String password) {
        return admin.getPassword().equals(password);
    }
}
