package com.sportevents.Services;

import com.sportevents.Models.Admin;

public interface AdminService {
    Admin getByLogin(String login);
    boolean Password(Admin admin, String password);
}
