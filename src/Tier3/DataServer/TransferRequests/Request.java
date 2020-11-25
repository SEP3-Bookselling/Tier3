package Tier3.DataServer.TransferRequests;

import java.io.Serializable;
import java.util.ArrayList;

import Tier3.DataServer.Models.*;
import Tier3.DataServer.Models.Booksale.BookSale;
import Tier3.DataServer.Models.Booksale.BookSaleNoID;

public class Request implements Serializable
{
  private EnumRequest EnumRequest;

  private BookSale bookSale;

  public BookSaleNoID getBookSaleNoID()
  {
    return bookSaleNoID;
  }

  public void setBookSaleNoID(BookSaleNoID bookSaleNoID)
  {
    this.bookSaleNoID = bookSaleNoID;
  }

  private BookSaleNoID bookSaleNoID;
  private ArrayList<BookSale> bookSales;

  private User User;
  private Card Card;

  public EnumRequest getEnumRequest()
  {
    return EnumRequest;
  }

  public void setEnumRequest(EnumRequest enumRequest)
  {
    EnumRequest = enumRequest;
  }

  public Tier3.DataServer.Models.Booksale.BookSale getBookSale()
  {
    return bookSale;
  }

  public void setBookSale(Tier3.DataServer.Models.Booksale.BookSale bookSale)
  {
    this.bookSale = bookSale;
  }

  public Tier3.DataServer.Models.User getUser()
  {
    return User;
  }

  public void setUser(Tier3.DataServer.Models.User user)
  {
    User = user;
  }

  public Tier3.DataServer.Models.Card getCard()
  {
    return Card;
  }

  public void setCard(Tier3.DataServer.Models.Card card)
  {
    Card = card;
  }

  // Prototype

  private String HelloWorld;

  public String getHelloWorld()
  {
    return HelloWorld;
  }

  public void setHelloWorld(String helloWorld)
  {
    HelloWorld = helloWorld;
  }

  public ArrayList<Tier3.DataServer.Models.Booksale.BookSale> getBookSales()
  {
    return bookSales;
  }

  public void setBookSales(
      ArrayList<Tier3.DataServer.Models.Booksale.BookSale> bookSales)
  {
    this.bookSales = bookSales;
  }
}
