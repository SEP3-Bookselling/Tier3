package Tier3.DataServer.Models;

public class User
{
  private String username;
  private String password;
  private int Id;

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

  public int getId()
  {
    Id = 1;
    return Id;
  }

  public void setId(int id)
  {
    Id = id;
  }
}
