package edu.miu.cs545.project.service.impl;

import com.auth0.client.auth.AuthAPI;
import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.json.auth.TokenHolder;
import com.auth0.json.mgmt.users.User;
import com.auth0.net.Request;
import edu.miu.cs545.project.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthAPI authAPI;
    private final ManagementAPI managementAPI;

    public AuthServiceImpl(@Value("${okta.oauth2.issuer}") String domain,
                           @Value("${okta.oauth2.client-id}") String clientId,
                           @Value("${okta.oauth2.client-secret}") String clientSecret,
                           @Value("${okta.oauth2.management-api-token}") String managementApiToken) {
        this.authAPI = new AuthAPI(domain, clientId, clientSecret);
        this.managementAPI = new ManagementAPI(domain, managementApiToken);
    }

    @Override
    public void changePassword(String email, String newPassword) {
        try {
            // Retrieve user by email
            List<User> users = managementAPI.users().listByEmail(email, null).execute();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found");
            }
            User user = users.get(0);
            User userToUpdate = new User();
            userToUpdate.setPassword(newPassword.toCharArray());
            managementAPI.users().update(user.getId(), userToUpdate).execute();
        } catch (Exception e) {
            throw new RuntimeException("Password change failed", e);
        }
    }

    @Override
    public String login(String username, String password) {
        try {
            TokenHolder holder = authAPI.login(username, password.toCharArray())
                    .setAudience("https://dev-j4xjehn5cg0hazyl.us.auth0.com/api/v2/")
                    .execute();
            return holder.getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed", e);
        }
    }

    @Override
    public User register(String email, String password) {
        try {
            User user = new User("auth0");
            user.setEmail(email);
            user.setPassword(password.toCharArray());
            user.setConnection("Username-Password-Authentication");
            Request<User> request = managementAPI.users().create(user);
            return request.execute();
        } catch (Exception e) {
            throw new RuntimeException("User registration failed", e);
        }
    }
}
