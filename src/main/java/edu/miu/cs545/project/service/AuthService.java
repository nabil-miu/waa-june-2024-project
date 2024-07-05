package edu.miu.cs545.project.service;

import com.auth0.json.mgmt.users.User;

public interface AuthService {
    void changePassword(String email, String newPassword);

    String login(String username, String password);

    User register(String email, String password);
}
