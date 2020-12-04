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



    @Override public void createUser(User user)
    {
        Connection connection = getConnectionToDB();

        try
        {
            PreparedStatement statement = connection.prepareStatement("Insert into Users (username, password, role) values (?,?,?)");
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getRole());

            statement.executeQuery();

            System.out.println("It workd");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override public ArrayList<User> getUserList(String username)
    {
        Connection connection = getConnectionToDB();
        ArrayList<User> userList = new ArrayList<>();
        System.out.println("User dao reached");

        if (username == null)
        {
            try
            {
                String sql = "select * from users";
                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    User user = new User();
                    user.setUsername(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));
                    user.setRole(resultSet.getString(3));
                    System.out.println("THE WATER IS FINE FATHER: " + user.getUsername() + " : " + user.getPassword());

                    userList.add(user);
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        else {
            try
            {
                String sql = "select * from users where username = " + "'" + username + "'" ;
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next())
                {
                    User user = new User();
                    user.setUsername(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));
                    user.setRole(resultSet.getString(3));
                    System.out.println("THE WATER IS FINE MOTHER: " + user.getUsername() + " : " + user.getPassword());

                    userList.add(user);
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return userList;
    }

}


/*
*  @Override
    public ArrayList<User> getAllUsers() {
        Connection connection = getConnectionToDB();
        ArrayList<User> userList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Users");

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
    public User getSpecificUser(String username) {
        Connection connection = getConnectionToDB();
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Users where username = ?;");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setRole(resultSet.getString(3));
                System.out.println("\t\t\t WORK PLEASE: " + user.getUsername() + " " + user.getPassword() + " " + user.getRole() + " ");
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("No users were found");
        return null;
    }
* */