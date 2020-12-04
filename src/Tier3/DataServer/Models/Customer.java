package Tier3.DataServer.Models;

public class Customer extends User
{
  private String postcode;
  private String firstName;
  private String lastName;
  private String email;
  private int phoneNumber;
  private double rating;
  private String address;

  public String getPostcode()
  {
    return postcode;
  }

  public void setPostcode(String postcode)
  {
    this.postcode = postcode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getRole() {
    return super.getRole();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override public String toString() {
    return "Customer{" + "postcode='" + postcode + '\'' + ", firstName='"
        + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='"
        + email + '\'' + ", phoneNumber=" + phoneNumber + ", rating=" + rating
        + ", address='" + address + '\'' + '}';
  }
}
