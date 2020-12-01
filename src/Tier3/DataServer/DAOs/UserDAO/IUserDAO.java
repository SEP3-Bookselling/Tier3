package Tier3.DataServer.DAOs.UserDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.util.ArrayList;

public interface IUserDAO {
    ArrayList<User> getAllUsers();
    User getSpecificUser(User user);
    ArrayList<Customer> getAllCustomers();
    Customer getCustomer();
    void createUser(Customer customer);
    void createCustomer(Customer customer);


}

