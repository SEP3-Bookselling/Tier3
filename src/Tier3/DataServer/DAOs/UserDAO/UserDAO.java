package Tier3.DataServer.DAOs.UserDAO;
import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.sql.*;
import java.util.ArrayList;


public class UserDAO implements IUserDAO {

    public Connection getConnectionToDB(){
        Connection connection = null;
        Statement statement = null;

        try
        {
            return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=thirdsemesterexam", LoginCredentials.username, LoginCredentials.password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        Connection connection = getConnectionToDB();
        ArrayList<User> userList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from User");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                User user = new User();
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setRole(resultSet.getString(3));

                userList.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public User getUser(User user) {
        Connection connection = getConnectionToDB();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Users where username =" + "'" + user.getUsername() + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                User user1 = new User();
                user1.setUsername(resultSet.getString(1));
                user1.setPassword(resultSet.getString(2));
                user1.setRole(resultSet.getString(3));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

        @Override
    public ArrayList<Customer> getAllCustomers() {
        getAllUsers();

        Connection connection = getConnectionToDB();
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from customer");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setUsername(resultSet.getString(1));
                customer.setAddress(resultSet.getString(2));
                customer.setPostcode(resultSet.getString(3));
                customer.setFirstName(resultSet.getString(4));
                customer.setLastName(resultSet.getString(5));
                customer.setEmail(resultSet.getString(6));
                customer.setPhoneNumber(resultSet.getInt(7));
                customer.setRating(resultSet.getDouble(8));

                customerList.add(customer);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return customerList;

    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public void createUser(User user)
    {

        Connection connection = getConnectionToDB();

        try
        {
            PreparedStatement insertUser = connection.prepareStatement("insert into  (username, password, role) values(?, ?, ?)");

            insertUser.setString(1, user.getUsername());
            insertUser.setString(2, user.getPassword());
            insertUser.setString(3,user.getRole());


            insertUser.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void createCustomer(Customer customer)
    {

        createUser(customer);
        Connection connection = getConnectionToDB();

        try
        {
            PreparedStatement insertCustomer = connection.prepareStatement("insert into  (username, address, postcode, firstname,lastname, email, phonenumber, rating) values(?, ?, ?, ?, ?, ?, ?, ?)");
            insertCustomer.setString(1, customer.getUsername());
            insertCustomer.setString(2, customer.getAddress());
            insertCustomer.setString(3, customer.getPostcode());
            insertCustomer.setString(4, customer.getFirstName());
            insertCustomer.setString(5, customer.getLastName());
            insertCustomer.setString(6, customer.getEmail());
            insertCustomer.setInt(7, customer.getPhoneNumber());
            insertCustomer.setDouble(8,customer.getRating());
            insertCustomer.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
