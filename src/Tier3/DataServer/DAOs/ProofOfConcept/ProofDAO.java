package Tier3.DataServer.DAOs.ProofOfConcept;



import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;

import java.sql.*;
import java.util.ArrayList;

public class ProofDAO implements IProofDAO
{
  private LoginCredentials login = new LoginCredentials();

  // Dummy string
  //private String dummyString = "Hello world!";

  public Connection getConnectionToDB()
  {
    Connection connection = null;
    Statement statement = null;
    try
    {
      return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=thirdsemesterexam", LoginCredentials.username, LoginCredentials.password);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return null;
  }


  //Proof of Concept stuff
  @Override public ArrayList<String> getAllMessages()
  {
    Connection connection = getConnectionToDB();
    ArrayList<String> messages = new ArrayList<>();

    try
    {
      PreparedStatement statement = connection.prepareStatement("select test from Test");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        messages.add(resultSet.getString(1));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return messages;
  }

  @Override public void insertMessage(String message)
  {
    Connection connection = getConnectionToDB();

    try
    {
      PreparedStatement statement = connection.prepareStatement("insert into test (test) values (?);");

      statement.setString(1,message);

      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String getHelloWorld()
  {
    Connection connection = getConnectionToDB();
    try
    {
      PreparedStatement statement = connection.prepareStatement("select test from Test");

      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next())
      {
        return resultSet.getString(1);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

}

