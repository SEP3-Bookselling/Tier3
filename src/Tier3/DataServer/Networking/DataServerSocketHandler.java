package Tier3.DataServer.Networking;

import Tier3.DataServer.DAOs.BookSaleDAO.IBookSaleDAO;
import Tier3.DataServer.DAOs.BookSaleDAO.BookSaleDAO;
import Tier3.DataServer.DAOs.CustomerDAO.CustomerDAO;
import Tier3.DataServer.DAOs.CustomerDAO.ICustomerDAO;
import Tier3.DataServer.DAOs.PurchaseDAO.IPurchaseDAO;
import Tier3.DataServer.DAOs.PurchaseDAO.PurchaseDAO;
import Tier3.DataServer.DAOs.UserDAO.IUserDAO;
import Tier3.DataServer.DAOs.UserDAO.UserDAO;
import Tier3.DataServer.Models.BookSale;
import Tier3.DataServer.Models.Customer;
import Tier3.DataServer.Models.PurchaseRequest;
import Tier3.DataServer.Models.Rating;
import Tier3.DataServer.Models.User;
import Tier3.DataServer.TransferRequests.Request;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class DataServerSocketHandler implements Runnable
{

  private Socket socket;

  private InputStream inputStream;
  private OutputStream outputStream;
  private Gson gson;
  private IBookSaleDAO bookSaleDAO;
  private IUserDAO userDAO;
  private ICustomerDAO customerDAO;
  private IPurchaseDAO purchaseDAO;


  public DataServerSocketHandler(Socket socket)
  {
    this.socket = socket;
    gson = new Gson();
    bookSaleDAO = new BookSaleDAO();
    userDAO = new UserDAO();
    customerDAO = new CustomerDAO();
    purchaseDAO = new PurchaseDAO();

    try
    {
      inputStream = socket.getInputStream();
      outputStream = socket.getOutputStream();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {

      byte[] inputFromTier2 = new byte[1024*1024];
      try
      {
        int arrLength = inputStream.read(inputFromTier2, 0, inputFromTier2.length);
        String arrString = new String(inputFromTier2, 0, arrLength);
        Request request = gson.fromJson(arrString, Request.class);

        switch (request.getEnumRequest())
        {
          case CreateBookSale:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getBookSale().toString()));
            reader.setLenient(true);

            BookSale bookSale = gson.fromJson(reader, BookSale.class);

            bookSaleDAO.createBookSale(bookSale);
            break;
          }

          case GetAllBookSales:
          {
            ArrayList<BookSale> bookSales = bookSaleDAO.getAllBookSales(request.getUsername());

            String jsonString = new Gson().toJson(bookSales);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);
            break;
          }

          case UpdateBookSale:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getBookSale().toString()));
            reader.setLenient(true);

            BookSale sale = gson.fromJson(reader, BookSale.class);

            bookSaleDAO.updateBookSale(sale);
            break;
          }

          case CreateUser:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getUser().toString()));
            reader.setLenient(true);
            User user = request.getUser();
            userDAO.createUser(user);
            break;
          }

          case CreateCustomer:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getCustomer().toString()));
            reader.setLenient(true);

            Customer customer = request.getCustomer();
            customerDAO.createCustomer(customer);
            break;
          }

          case GetUserList:
          {
            ArrayList<User> users = userDAO.getUserList(request.getUsername());
            String jsonString = new Gson().toJson(users);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);
            break;
          }

          case GetSpecificCustomer:
          {
            ArrayList<Customer> customers = customerDAO.getCustomer(request.getUsername());

            String jsonString = new Gson().toJson(customers);

            byte[] array = jsonString.getBytes();
            outputStream.write(array,0,array.length);
            break;
          }

          case DeleteCustomer:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getUsername()));
            reader.setLenient(true);

            String userToBeDeleted = gson.fromJson(reader, String.class);
            customerDAO.deleteCustomer(userToBeDeleted);
            break;
          }

          case DeleteBookSale:
          {
            JsonReader reader = new JsonReader(new StringReader("" + request.getId()));
            reader.setLenient(true);

            int idToDelete = gson.fromJson(reader, Integer.class);
            bookSaleDAO.deleteBookSale(idToDelete);

            break;
          }

          case UpdateCustomer:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getCustomer().toString()));
            reader.setLenient(true);

            Customer customer = gson.fromJson(reader, Customer.class);

            customerDAO.updateCustomer(customer);
            break;
          }

          case GetRatings:
          {
            String username = request.getUsername();
            customerDAO.getRatings(username);

            ArrayList<Double> rating = customerDAO.getRatings(username);
            String jsonString = new Gson().toJson(rating);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);

            break;
          }

          case Rate:
          {
            Rating rating = request.getRating();
            customerDAO.rateCustomer(rating);

            break;
          }

          case GetSpecificUserLogin:
          {
            User user = userDAO.getSpecificUserLogin(request.getUsername(), request.getPassword());

            String jsonString = new Gson().toJson(user);

            byte[] array = jsonString.getBytes();
            outputStream.write(array,0,array.length);

            break;
          }

          case DeleteUser:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getUsername()));
            reader.setLenient(true);

            String username = gson.fromJson(reader, String.class);
            userDAO.deleteUser(username);

            break;
          }

          case UpdateUser:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getUser().toString()));
            reader.setLenient(true);

            User user = gson.fromJson(reader, User.class);

            userDAO.updateUser(user);

            break;
          }


          case CreatePurchaseRequest:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getPurchaseRequests().toString()));
            reader.setLenient(true);

            ArrayList<PurchaseRequest> purchaseRequests = request.getPurchaseRequests();
            purchaseDAO.createPurchaseRequest(purchaseRequests);
            break;
          }

          case GetPurchaseRequest:
          {
            ArrayList<PurchaseRequest> purchaseRequests = purchaseDAO.getPurchaseRequest(request.getUsername());

            String jsonString = new Gson().toJson(purchaseRequests);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);
            break;
          }

          case GetPurchaseRequestFromId:
          {
            ArrayList purchaseRequests = purchaseDAO.getPurchaseRequestFromId(request.getId());

            String jsonString = new Gson().toJson(purchaseRequests);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);
            break;
          }

          case DeletePurchaseRequest:
          {
            JsonReader reader = new JsonReader(new StringReader("" + request.getId()));
            reader.setLenient(true);

            int idToDelete = gson.fromJson(reader, Integer.class);
            purchaseDAO.deletePurchaseRequest(idToDelete);

          }

          case DeletePurchaseRequestFromSaleId:
          {
            JsonReader reader = new JsonReader(new StringReader("" + request.getId()));
            reader.setLenient(true);

            int idToDelete = gson.fromJson(reader, Integer.class);
            purchaseDAO.deletePurchaseRequestFromSaleId(idToDelete);
          }
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
  }
}
