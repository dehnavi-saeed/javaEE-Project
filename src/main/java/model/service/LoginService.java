package model.service;

import model.DA.DBConnectionManager;
import model.DA.UserDA;
import model.entity.User;

public class LoginService {
    private User user;
    private DBConnectionManager manager;
    public LoginService(String username, String password, DBConnectionManager manager) {
        user.setUsername(username);
        user.setPassword(password);
        this.manager=manager;
    }
    public boolean isvalid(){
        UserDA userDA = new UserDA(manager);
        return userDA.isValidUsernamePassword(user);
    }
}
