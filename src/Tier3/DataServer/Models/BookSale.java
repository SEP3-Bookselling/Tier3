package Tier3.DataServer.Models;

public class BookSale
{
  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getEdition()
  {
    return edition;
  }

  public void setEdition(String edition)
  {
    this.edition = edition;
  }

  public String getCondition()
  {
    return condition;
  }

  public void setCondition(String condition)
  {
    this.condition = condition;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public boolean isHardCopy()
  {
    return hardCopy;
  }

  public void setHardCopy(boolean hardCopy)
  {
    this.hardCopy = hardCopy;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public int getID()
  {
    return ID;
  }

  public void setID(int ID)
  {
    this.ID = ID;
  }

  private String title;
  private String author;
  private String edition;
  private String condition;
  private String subject;
  private String image;
  private double price;
  private boolean hardCopy;
  private User user;
  private int ID;

  @Override public String toString()
  {
    return "BookSale{" +
        "title='" + title + "'" +
        ", author='" + author + "'" +
        ", edition='" + edition + "'" +
        ", condition='" + condition + "'"+
        ", subject='" + subject + "'" +
        ", image='" + image + "'" +
        ", price=" + price +
        ", hardCopy=" + hardCopy +
        ", user=" + user.getId() +
        ", ID=" + ID + "}";

  }
}
