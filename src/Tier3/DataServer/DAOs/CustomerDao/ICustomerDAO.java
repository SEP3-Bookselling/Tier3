package Tier3.DataServer.DAOs.CustomerDAO;

import Tier3.DataServer.Models.Customer;

import java.util.ArrayList;

public interface ICustomerDAO
{
    void createCustomer(Customer customer);
    Customer getSpecificCustomer(String username);
    ArrayList<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(String username);

}
