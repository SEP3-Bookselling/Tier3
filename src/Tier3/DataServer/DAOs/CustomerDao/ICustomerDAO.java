package Tier3.DataServer.DAOs.CustomerDao;

import Tier3.DataServer.Models.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerDAO
{
    void createCustomer(Customer customer);
    Customer getSpecificCustomer(String username);
    ArrayList<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(String username);

}
