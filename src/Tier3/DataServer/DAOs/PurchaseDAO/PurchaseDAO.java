package Tier3.DataServer.DAOs.PurchaseDAO;

import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.BookSale;
import Tier3.DataServer.Models.PurchaseRequest;
import com.sun.tools.jconsole.JConsoleContext;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;

public class PurchaseDAO implements IPurchaseDAO {

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
  public void createPurchaseRequest(
          ArrayList<PurchaseRequest> purchaseRequests) {
    String sqlPurchaseRequest = "insert into Purchase (bookSaleId, buyer, seller) values (?, ?, ?);";

    Connection connection = getConnectionToDB();

    try {
      for (PurchaseRequest purchaseRequest : purchaseRequests) {
        PreparedStatement insertPurchaseData = connection
                .prepareStatement(sqlPurchaseRequest);

        insertPurchaseData.setInt(1, purchaseRequest.getBookSale().getBookSaleID());
        insertPurchaseData.setString(2, purchaseRequest.getBuyer());
        insertPurchaseData.setString(3, purchaseRequest.getSeller());

        insertPurchaseData.executeUpdate();

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<PurchaseRequest> getPurchaseRequest(String username) {

    Connection connection = getConnectionToDB();
    ArrayList<PurchaseRequest> purchaseList = new ArrayList<>();

    if (username == null) {
      try {
        PreparedStatement statement = connection.prepareStatement("select distinct p.booksaleId as BooksaleId, p.reqid, p.buyer, p.seller, b.title, b.author, b.edition, b.condition, b.subject, b.image, b.price, b.hardcopy, b.description, b.username from Purchase p inner join booksale b on p.booksaleid = b.booksaleid");



        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
          PurchaseRequest request = new PurchaseRequest();
          BookSale saleInRequest = new BookSale();

          saleInRequest.setBookSaleID(resultSet.getInt(1));
          request.setRequestId(resultSet.getInt(2));
          request.setBuyer(resultSet.getString(3));
          request.setSeller(resultSet.getString(4));
          saleInRequest.setTitle(resultSet.getString(5));
          saleInRequest.setAuthor(resultSet.getString(6));
          saleInRequest.setEdition(resultSet.getString(7));
          saleInRequest.setCondition(resultSet.getString(8));
          saleInRequest.setSubject(resultSet.getString(9));
          saleInRequest.setImage(resultSet.getString(10));
          saleInRequest.setPrice(resultSet.getDouble(11));
          saleInRequest.setHardCopy(resultSet.getBoolean(12));
          saleInRequest.setDescription(resultSet.getString(13));
          saleInRequest.setUsername(resultSet.getString(14));

          request.setBookSale(saleInRequest);
          purchaseList.add(request);

        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      try {

        String getPurchaseRequestSQL = "select distinct p.booksaleId as BooksaleId, p.reqid, p.buyer, p.seller, b.title, b.author, b.edition, b.condition, b.subject, b.image, b.price, b.hardcopy, b.description, b.username from Purchase p inner join booksale b on p.booksaleid = b.booksaleid where buyer = '" + username + "'";

        PreparedStatement statement = connection.prepareStatement(getPurchaseRequestSQL);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
          PurchaseRequest requestToGet = new PurchaseRequest();
          BookSale saleInRequest = new BookSale();

          saleInRequest.setBookSaleID(resultSet.getInt(1));
          requestToGet.setRequestId(resultSet.getInt(2));
          requestToGet.setBuyer(resultSet.getString(3));
          requestToGet.setSeller(resultSet.getString(4));
          saleInRequest.setTitle(resultSet.getString(5));
          saleInRequest.setAuthor(resultSet.getString(6));
          saleInRequest.setEdition(resultSet.getString(7));
          saleInRequest.setCondition(resultSet.getString(8));
          saleInRequest.setSubject(resultSet.getString(9));
          saleInRequest.setImage(resultSet.getString(10));
          saleInRequest.setPrice(resultSet.getDouble(11));
          saleInRequest.setHardCopy(resultSet.getBoolean(12));
          saleInRequest.setDescription(resultSet.getString(13));
          saleInRequest.setUsername(resultSet.getString(14));

          requestToGet.setBookSale(saleInRequest);
          purchaseList.add(requestToGet);

        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return purchaseList;
}

  @Override public ArrayList<PurchaseRequest> getPurchaseRequestFromId(int id) {
    Connection connection = getConnectionToDB();
    ArrayList<PurchaseRequest> purchaseList = new ArrayList<>();

    try {
      PreparedStatement statement = connection.prepareStatement("select * from purchase where booksaleId =" + id);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        PurchaseRequest requestToGet = new PurchaseRequest();

        requestToGet.setRequestId(resultSet.getInt(1));
        requestToGet.setBuyer(resultSet.getString(3));
        requestToGet.setSeller(resultSet.getString(4));

        purchaseList.add(requestToGet);
      }

    }
    catch (SQLException e) {
      e.printStackTrace();
    }

    return purchaseList;
  }

  @Override public void deletePurchaseRequest(int id)
  {
    Connection connection = getConnectionToDB();

    try
    {
      String deletePurchaseRequestSQL = "DELETE FROM purchase WHERE reqId = " + id;
      PreparedStatement deletePurchaseRequest = connection.prepareStatement(deletePurchaseRequestSQL);

      deletePurchaseRequest.executeUpdate();


    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  @Override public void deletePurchaseRequestFromSaleId(int id) {
    Connection connection = getConnectionToDB();

    try {
      String deleteWithSaleIdSQL = "Delete from purchase where bookSaleId = " + id;
      PreparedStatement deleteWithSaleId = connection.prepareStatement(deleteWithSaleIdSQL);

      deleteWithSaleId.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
