package Tier3.DataServer.TransferRequests;

import java.io.Serializable;
import Tier3.DataServer.Models.*;

public class Request implements Serializable
{
  private EnumRequest RequestEnum;

  private BookSale BookSale;
  private User User;
  private Card Card;

  public EnumRequest getRequestEnum()
  {
    return RequestEnum;
  }

  public void setRequestEnum(EnumRequest requestEnum)
  {
    RequestEnum = requestEnum;
  }

  public Tier3.DataServer.Models.BookSale getBookSale()
  {
    return BookSale;
  }

  public void setBookSale(Tier3.DataServer.Models.BookSale bookSale)
  {
    BookSale = bookSale;
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

  public String getHelloWorld()
  {
    return HelloWorld;
  }

  public void setHelloWorld(String helloWorld)
  {
    HelloWorld = helloWorld;
  }

  // Prototype
  public String HelloWorld;
}
