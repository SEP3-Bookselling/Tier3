package Tier3.DataServer.DAOs.UserDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.util.ArrayList;

public interface IUserDAO {
    ArrayList<User> getAllUsers();
    User getSpecificUser(String username, String password);



}

