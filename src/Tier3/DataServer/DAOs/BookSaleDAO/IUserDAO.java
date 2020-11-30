package Tier3.DataServer.DAOs.BookSaleDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.util.ArrayList;

public interface IUserDAO {
    ArrayList<User> getAllUsers();
    User getUser(User user);
    ArrayList<Customer> getAllCustomers();
    Customer getCustomer();
    void createUser(User user);
    void createCustomer(Customer customer);

}

