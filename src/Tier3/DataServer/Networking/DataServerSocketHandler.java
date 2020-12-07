package Tier3.DataServer.Networking;

import Tier3.DataServer.DAOs.BookSaleDAO.IBookSaleDAO;
import Tier3.DataServer.DAOs.BookSaleDAO.BookSaleDAO;
import Tier3.DataServer.DAOs.CustomerDAO.CustomerDAO;
import Tier3.DataServer.DAOs.CustomerDAO.ICustomerDAO;
import Tier3.DataServer.DAOs.UserDAO.IUserDAO;
import Tier3.DataServer.DAOs.UserDAO.UserDAO;
import Tier3.DataServer.DAOs.ProofOfConcept.IProofDAO;
import Tier3.DataServer.DAOs.ProofOfConcept.ProofDAO;
import Tier3.DataServer.Models.BookSale;
import Tier3.DataServer.Models.Customer;
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
  private IProofDAO testController; //TODO: May or may not work depending on the Interface injection stuff
  private Gson gson;
  private IBookSaleDAO bookSaleDAO;
  private IUserDAO userDAO;
  private ICustomerDAO customerDAO;


  public DataServerSocketHandler(Socket socket)
  {
    this.socket = socket;
    gson = new Gson();
    bookSaleDAO = new BookSaleDAO();
    userDAO = new UserDAO();
    testController = new ProofDAO();
    customerDAO = new CustomerDAO();

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

      byte[] inputFromTier2 = new byte[1024];
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

          /*
          case sendProofOfConcept:
            {
              JsonReader reader = new JsonReader(new StringReader(request.getHelloWorld()));
              reader.setLenient(true);
              String putMessage = gson.fromJson(reader, String.class);
              testController.insertMessage(putMessage);
              break;
            }
            */

        }

      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    //}
  }





























  /*
  @Override public void run()
  {
    // TODO: Make sure the GSON file is V_2.8.2
    while (true)
    {
      byte[] byteArr = new byte[1024];

      try
      {
        int arrLength = inputStream.read(byteArr, 0, byteArr.length);
        String arrString = new String(byteArr, 0, arrLength);
        Request request = gson.fromJson(arrString, Request.class);

        switch (request.getEnumRequest())
        {
          case recieveProofOfConcept:
          {
            ArrayList<String> list = controller.getAllMessages();
            StringBuffer sb = new StringBuffer();

            for (String s: list)
            {
              sb.append(s);
              sb.append(" : ");
            }

            String str = '"' + sb.toString() + '"';
            byte[] array = str.getBytes();
            outputStream.write(array, 0, array.length);

            break;
          }

          case sendProofOfConcept:
          {
            JsonReader reader = new JsonReader(new StringReader(request.getHelloWorld()));
            reader.setLenient(true);
            String putMessage = gson.fromJson(reader, String.class);
            controller.insertMessage(putMessage);
            break;

          }
        }

      }
      catch (IOException | IllegalStateException | JsonSyntaxException e)
      {
        e.printStackTrace();
      }
    }
  }
*/
}
