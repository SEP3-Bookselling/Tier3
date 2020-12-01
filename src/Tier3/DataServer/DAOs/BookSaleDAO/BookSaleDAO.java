package Tier3.DataServer.DAOs.BookSaleDAO;


import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.Booksale.BookSale;
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

  @Override public ArrayList<BookSale> getAllBookSales()
  {
    Connection connection = getConnectionToDB();
    ArrayList<BookSale> bookSaleList = new ArrayList<>();

    try
    {
      PreparedStatement statement = connection.prepareStatement("select * from BookSale");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        BookSale bookSale = new BookSale();

        bookSale.setTitle(resultSet.getString(1));
        bookSale.setAuthor(resultSet.getString(2));
        bookSale.setEdition(resultSet.getString(3));
        bookSale.setCondition(resultSet.getString(4));
        bookSale.setSubject(resultSet.getString(5));
        bookSale.setImage(resultSet.getString(6));
        bookSale.setPrice(resultSet.getDouble(7));
        bookSale.setHardCopy(resultSet.getBoolean(8));
        bookSale.setDescription(resultSet.getString(9));
        bookSale.setUsername(resultSet.getString(10));
        bookSale.setBookSaleID(resultSet.getInt(11));

        bookSaleList.add(bookSale);

      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return bookSaleList;
  }

  @Override public BookSale getBookSale()
  {
    return null;

    /*
    if(resultSet.next()){
    * String strin1 = resultSet.GetString("columnLabel");
    * int int1 = resultSet.getInt("customerID"); //getInt er navnet på kollonnen
    * Booksale booksale = new BookSale(strin1,int1);
    * return booksale
    *}
    */

  }

  @Override public void createBookSale(BookSale bookSale)
  {
    Connection connection = getConnectionToDB();

    try
    {
      PreparedStatement insertBookSaleData = connection.prepareStatement("insert into BookSale (title, author, edition, condition, subject, image, price, hardCopy, description , username) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

      // Might be getString? Check up on that
      insertBookSaleData.setString(1, bookSale.getTitle());
      insertBookSaleData.setString(2, bookSale.getAuthor());
      insertBookSaleData.setString(3, bookSale.getEdition());
      insertBookSaleData.setString(4, bookSale.getCondition());
      insertBookSaleData.setString(5, bookSale.getSubject());
      insertBookSaleData.setString(6, bookSale.getImage());
      insertBookSaleData.setDouble(7,bookSale.getPrice());
      insertBookSaleData.setBoolean(8,bookSale.isHardCopy());
      insertBookSaleData.setString(9,bookSale.getDescription());
      insertBookSaleData.setString(10,bookSale.getUsername());

      insertBookSaleData.executeUpdate();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteBookSale(int id) {
    Connection connection = getConnectionToDB();

    try {
      PreparedStatement deleteBookSaleData = connection.prepareStatement("DELETE FROM BookSale WHERE bookSaleID =" + id);

      deleteBookSaleData.executeUpdate();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}




/*
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
          + "\"customerID\":" + resultSet.getInt(9) + ","
          + "\"isAvailable\":" + resultSet.getBoolean(10) + ","
          + "\"id\":" + "" + resultSet.getInt(11)
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
*/

/*
      list += "{"
          + "\"title\":" + "\"" + resultSet.getString(1) + "\","
          + "\"author\":" + "\"" + resultSet.getString(2) + "\","
          + "\"edition\":" + "\"" + resultSet.getString(3) + "\","
          + "\"condition\":" + "\"" + resultSet.getString(4) + "\","
          + "\"subject\":" + "\"" + resultSet.getString(5) + "\","
          + "\"image\":" + "\"" + resultSet.getString(6) + "\","
          + "\"price\":" + resultSet.getDouble(7) + ","
          + "\"hardCopy\":"  + resultSet.getBoolean(8) + ","
          + "\"customerID\":" + resultSet.getInt(9) + ","
          + "\"isAvailable\":" + resultSet.getBoolean(10) + ","
          + "\"id\":" + "" + resultSet.getInt(11)
          + "},";
      }
      result = list.replaceFirst(".$" , "");
      result = "[" + result + "]";
      */
