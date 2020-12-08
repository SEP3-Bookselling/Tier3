package Tier3.DataServer.DAOs.PurchaseDAO;

import Tier3.DataServer.Models.PurchaseRequest;

import java.util.ArrayList;

public interface IPurchaseDAO {

  void createPurchaseRequest(ArrayList<PurchaseRequest> purchaseRequests);
  ArrayList<PurchaseRequest> getPurchaseRequest(String username);
  void deletePurchaseRequest(int id);
}
