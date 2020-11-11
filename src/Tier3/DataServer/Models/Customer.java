package Tier3.DataServer.Models;

public class Customer extends User
{
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public double getRating()
  {
    return rating;
  }

  public void setRating(double rating)
  {
    this.rating = rating;
  }

  private String location;
  private String firstName;
  private String lastName;
  private String email;
  private int phoneNumber;
  private double rating;
}
