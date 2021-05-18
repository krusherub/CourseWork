package com.sportevents.Dao;
import com.sportevents.Models.Admin;
public interface AdminDao extends AbstractDao<Admin> {
    Admin getByLogin (String login);
}
