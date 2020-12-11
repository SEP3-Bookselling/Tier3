package Tier3.DataServer.TransferRequests;

import java.io.Serializable;
import java.util.ArrayList;

import Tier3.DataServer.Models.*;
import Tier3.DataServer.Models.BookSale;

public class Request implements Serializable
{
  private EnumRequest EnumRequest;

  private BookSale BookSale;
  private ArrayList<BookSale> bookSales;
  private User User;
  private Customer Customer;
  private int Id;
  private Rating rating;

  private String username;
  private String password;

  private ArrayList<PurchaseRequest> purchaseRequests;

  public ArrayList<PurchaseRequest> getPurchaseRequests() {
    return purchaseRequests;
  }

  public void setPurchaseRequests(ArrayList<PurchaseRequest> purchaseRequests) {
    this.purchaseRequests = purchaseRequests;
  }


  public EnumRequest getEnumRequest()
  {
    return EnumRequest;
  }

  public void setEnumRequest(EnumRequest enumRequest)
  {
    EnumRequest = enumRequest;
  }

  public BookSale getBookSale()
  {
    return BookSale;
  }

  public void setBookSale(BookSale bookSale)
  {
    this.BookSale = bookSale;
  }

  public User getUser()
  {
    System.out.println(User);
    return User;
  }

  public Customer getCustomer(){
    return Customer;
  }

  public void setCustomer(Customer customer) {
    this.Customer = customer;
  }

  public void setUser(User user)
  {
    User = user;
  }


  // Prototype

  public int getId() {
    return Id;
  }


  public ArrayList<BookSale> getBookSales()
  {
    return bookSales;
  }

  public void setBookSales(
      ArrayList<BookSale> bookSales)
  {
    this.bookSales = bookSales;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  @Override public String toString() {
    return "Request{" + "EnumRequest=" + EnumRequest + ", BookSale=" + BookSale
        + ", bookSales=" + bookSales + ", User=" + User + ", Customer="
        + Customer + ", Id=" + Id + ", username='" + username + '\''
        + ", password='" + password + '\'' + ", purchaseRequests="
        + purchaseRequests + '\'' + '}';
  }
}
