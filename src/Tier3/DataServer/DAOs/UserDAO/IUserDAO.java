package Tier3.DataServer.DAOs.UserDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.util.ArrayList;

public interface IUserDAO {

    void createUser(Customer customer);
    ArrayList<User> getUserList(String username);

}

