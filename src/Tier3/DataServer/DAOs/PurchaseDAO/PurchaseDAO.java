package Tier3.DataServer.DAOs.PurchaseDAO;

import Tier3.DataServer.DAOs.PersonalLogin.LoginCredentials;
import Tier3.DataServer.Models.PurchaseRequest;

import java.sql.*;
import java.util.ArrayList;

public class PurchaseDAO implements IPurchaseDAO {

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

  @Override public void createPurchaseRequest(
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

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<PurchaseRequest> getPurchaseRequest(
      String username) {
    return null;
  }

  @Override public void deletePurchaseRequest(int id) {

  }
}
