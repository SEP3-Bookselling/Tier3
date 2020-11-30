package Tier3.DataServer.TransferRequests;

import java.io.Serializable;
import java.util.ArrayList;

import Tier3.DataServer.Models.*;
import Tier3.DataServer.Models.Booksale.BookSale;

public class Request implements Serializable
{
  private EnumRequest EnumRequest;

  private BookSale BookSale;
  private ArrayList<BookSale> bookSales;
  private User User;
  private Card Card;
  private int Id;




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
    return User;
  }

  public void setUser(User user)
  {
    User = user;
  }

  public Card getCard()
  {
    return Card;
  }

  public void setCard(Card card)
  {
    Card = card;
  }

  // Prototype

  private String HelloWorld;

  public String getHelloWorld()
  {
    return HelloWorld;
  }

  public int getId() {
    return Id;
  }

  public void setHelloWorld(String helloWorld)
  {
    HelloWorld = helloWorld;
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
}
