package Tier3.DataServer.DAOs.CustomerDAO;

import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO implements ICustomerDAO{

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
    public void createCustomer(Customer customer)
    {
        String sqlUser ="insert into Users(username, password, role) values(?,?,?);";
        String sqlCustomer = "insert into Customer (username, address, postcode, firstname,lastname, email, phonenumber, rating) values(?, ?, ?, ?, ?, ?, ?, ?);";

        Connection connection = getConnectionToDB();

        try
        {

            PreparedStatement insertUser = connection.prepareStatement(sqlUser);
            insertUser.setString(1,customer.getUsername());
            insertUser.setString(2,customer.getPassword());
            insertUser.setString(3,customer.getRole());
            insertUser.executeUpdate();


            PreparedStatement insertCustomer = connection.prepareStatement(sqlCustomer);
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

    @Override
    public ArrayList<Customer> getCustomer(String username) {

        Connection connection = getConnectionToDB();
        ArrayList<Customer> customerList = new ArrayList<>();

        if (username == null) {
            try {

                String sql = "select distinct c.username as Username, u.password, c.address, c.postcode, c.firstname, c.lastname, c.email, c.phonenumber, c.rating, u.role from customer c inner join users u on c.username = u.username";

                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setUsername(resultSet.getString(1));
                    customer.setPassword(resultSet.getString(2));
                    customer.setAddress(resultSet.getString(3));
                    customer.setPostcode(resultSet.getString(4));
                    customer.setFirstName(resultSet.getString(5));
                    customer.setLastName(resultSet.getString(6));
                    customer.setEmail(resultSet.getString(7));
                    customer.setPhoneNumber(resultSet.getInt(8));
                    customer.setRating(resultSet.getDouble(9));
                    customer.setRole(resultSet.getString(10));

                    customerList.add(customer);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            try {

                String sql =
                    "select distinct c.username as Username, u.password, c.address, c.postcode, c.firstname, c.lastname, c.email, c.phonenumber, c.rating, u.role from customer c inner join users u on c.username = u.username where c.username = '"
                        + username + "'";

                PreparedStatement statement = connection.prepareStatement(sql);
                //statement.setString(1,username);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setUsername(resultSet.getString(1));
                    customer.setPassword(resultSet.getString(2));
                    customer.setAddress(resultSet.getString(3));
                    customer.setPostcode(resultSet.getString(4));
                    customer.setFirstName(resultSet.getString(5));
                    customer.setLastName(resultSet.getString(6));
                    customer.setEmail(resultSet.getString(7));
                    customer.setPhoneNumber(resultSet.getInt(8));
                    customer.setRating(resultSet.getDouble(9));
                    customer.setRole(resultSet.getString(10));

                    customerList.add(customer);
                }

            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer) {

        Connection connection = getConnectionToDB();

        try {
            PreparedStatement updateCustomerData = connection.prepareStatement("update Customer set address = ?, postcode = ?, firstname = ?, lastname = ?, email = ?, phonenumber = ?, rating = ? where username = " + "'" + customer.getUsername() + "'");
            //customer
            updateCustomerData.setString(1, customer.getAddress());
            updateCustomerData.setString(2, customer.getPostcode());
            updateCustomerData.setString(3, customer.getFirstName());
            updateCustomerData.setString(4, customer.getLastName());
            updateCustomerData.setString(5, customer.getEmail());
            updateCustomerData.setInt(6, customer.getPhoneNumber());
            updateCustomerData.setDouble(7, customer.getRating());
            updateCustomerData.executeUpdate();


            //user
            PreparedStatement updateUserData = connection.prepareStatement("update Users set password = ? Where username = " + "'" + customer.getUsername() + "'");
            updateUserData.setString(1, customer.getPassword());
            updateUserData.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        @Override
    public void deleteCustomer(String username) {
        Connection connection = getConnectionToDB();

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customer WHERE username = ?");
            statement.setString(1,username);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Double> getRatings(String username)
    {
        Connection connection = getConnectionToDB();
        double rating = 0;
        ArrayList<Double> ratingList = new ArrayList<>();
            try {
                String sql = "select rating from Rating where username = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,username);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    rating =  Double.parseDouble(resultSet.getString("rating"));
                    ratingList.add(rating);
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            return ratingList;
    }



    @Override
    public void rateCustomer(String username, double rating) {

    }
}


