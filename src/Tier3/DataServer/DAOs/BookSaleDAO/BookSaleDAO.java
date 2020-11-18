package Tier3.DataServer.DAOs.BookSaleDAO;


import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.BookSale;

import java.sql.*;
import java.util.ArrayList;

public class BookSaleDAO implements IBookSaleDAO
{

  public Connection getConnectionToDB()
  {
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

  @Override public String getAllBookSales()
  {
    Connection connection = getConnectionToDB();

    ArrayList<String> bookSaleList = new ArrayList<>();
    String list = "";
    String result = "";
    try
    {
      PreparedStatement statement = connection.prepareStatement("select * from BookSale");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
      list += "{"
          + "\"title\":" + "\"" + resultSet.getString(1) + "\","
          + "\"author\":" + "\"" + resultSet.getString(2) + "\","
          + "\"edition\":" + "\"" + resultSet.getString(3) + "\","
          + "\"condition\":" + "\"" + resultSet.getString(4) + "\","
          + "\"subject\":" + "\"" + resultSet.getString(5) + "\","
          + "\"image\":" + "\"" + resultSet.getString(6) + "\","
          + "\"price\":" + resultSet.getDouble(7) + ","
          + "\"hardCopy\":"  + resultSet.getBoolean(8) + ","
          + "\"username\":" + resultSet.getString(9) + ","
          + "\"bookId\":" + "" + resultSet.getInt(10)
          + "},";
      }
      result = list.replaceFirst(".$" , "");
      result = "[" + result + "]";
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  @Override public BookSale getBookSale()
  {
    return null;
  }

  @Override public void createBookSale(BookSale bookSale)
  {
    Connection connection = getConnectionToDB();

    try
    {
      PreparedStatement insertBookSaleData = connection.prepareStatement("insert into BookSale (title, author, edition, condition, subject, image, price, hardCopy, username, bookSaleID) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

      // Might be getString? Check up on that
      insertBookSaleData.setString(1, bookSale.getTitle());
      insertBookSaleData.setString(2, bookSale.getAuthor());
      insertBookSaleData.setString(3, bookSale.getEdition());
      insertBookSaleData.setString(4, bookSale.getCondition());
      insertBookSaleData.setString(5, bookSale.getSubject());
      insertBookSaleData.setString(6, bookSale.getImage());
      insertBookSaleData.setDouble(7,bookSale.getPrice());
      insertBookSaleData.setBoolean(8,bookSale.isHardCopy());
      insertBookSaleData.setInt(9,bookSale.getSellerID());
      insertBookSaleData.setInt(10,bookSale.getId());
      insertBookSaleData.setBoolean(11, bookSale.isAvailable());

      insertBookSaleData.executeUpdate();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
