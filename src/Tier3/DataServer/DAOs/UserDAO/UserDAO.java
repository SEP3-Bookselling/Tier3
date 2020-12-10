package Tier3.DataServer.DAOs.UserDAO;

import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.User;

import java.sql.*;
import java.util.ArrayList;


public class UserDAO implements IUserDAO {

    public Connection getConnectionToDB() {
        Connection connection = null;
        Statement statement = null;

        try {
            return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=thirdsemesterexam", LoginCredentials.username, LoginCredentials.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void createUser(User user) {
        Connection connection = getConnectionToDB();

        try {
            PreparedStatement statement = connection.prepareStatement("Insert into Users (username, password, role) values (?,?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getUserList(String username) {
        Connection connection = getConnectionToDB();
        ArrayList<User> userList = new ArrayList<>();

        if (username == null) {
            try {
                String sql = "select * from users where role = 'Moderator' or role = 'Admin'\n";
                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    User user = new User();
                    user.setUsername(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));
                    user.setRole(resultSet.getString(3));

                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            try {
                String sql = "select * from users where username = " + "'" + username + "'";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    User user = new User();
                    user.setUsername(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));
                    user.setRole(resultSet.getString(3));

                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void deleteUser(String username) {
        Connection connection = getConnectionToDB();

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE username = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Connection connection = getConnectionToDB();

        try {
            String sql = "update Users set password = ? Where username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,user.getPassword());
            statement.setString(2,user.getUsername());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getSpecificUserLogin(String username, String password) {
        Connection connection = getConnectionToDB();
        User user = new User();
        try {
            String sql = "select * from users where username = ? and password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setRole(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

}
