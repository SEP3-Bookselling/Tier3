package Tier3.DataServer.DAOs.CustomerDAO;

import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.Rating;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ICustomerDAO
{
    void createCustomer(Customer customer);
    ArrayList<Customer> getCustomer(String username);
    void updateCustomer(Customer customer);
    void deleteCustomer(String username);

    ArrayList<Double> getRatings(String username);
    void rateCustomer(Rating rating);

}
