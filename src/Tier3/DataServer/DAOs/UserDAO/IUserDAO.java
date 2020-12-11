package Tier3.DataServer.DAOs.UserDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.util.ArrayList;

public interface IUserDAO {

    void createUser(User user);
    ArrayList<User> getUserList(String username);
    void deleteUser(String username);
    void updateUser(User user);
    User getSpecificUserLogin(String username, String password);

}

