package Tier3.DataServer.Networking;

import Tier3.DataServer.DAOs.BookSaleDAO.IBookSaleDAO;
import Tier3.DataServer.DAOs.BookSaleDAO.BookSaleDAO;
import Tier3.DataServer.DAOs.ProofOfConcept.IProofDAO;
import Tier3.DataServer.DAOs.ProofOfConcept.ProofDAO;
import Tier3.DataServer.Models.BookSale;
import Tier3.DataServer.TransferRequests.Request;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class DataServerSocketHandler implements Runnable
{
  // Initial branch creation
  private Socket socket;

  private InputStream inputStream;
  private OutputStream outputStream;
  private IProofDAO testController; //TODO: May or may not work depending on the Interface injection stuff
  private Gson gson;
  private IBookSaleDAO bookSaleDAO;


  public DataServerSocketHandler(Socket socket)
  {
    this.socket = socket;
    gson = new Gson();
    //controller = new ProofDAO();
    bookSaleDAO = new BookSaleDAO();
    testController = new ProofDAO();

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
    //while (true)
    //{
      byte[] inputFromTier2 = new byte[1024];
      try
      {
        int arrLength = inputStream.read(inputFromTier2, 0, inputFromTier2.length);
        String arrString = new String(inputFromTier2, 0, arrLength);
        //JsonReader enumReader = new JsonReader(new StringReader(arrString));
        //enumReader.setLenient(true);
        Request request = gson.fromJson(arrString, Request.class);

        switch (request.getEnumRequest())
        {
          case CreateBookSale:
            {
              JsonReader reader = new JsonReader(new StringReader(request.getBookSale().toString()));
              reader.setLenient(true);
              String message = request.getBookSale().toString();
              System.out.println(message);

              BookSale bookSale = request.getBookSale();
              //BookSale bookSale = new Gson().fromJson(message, BookSale.class);

              bookSaleDAO.createBookSale(bookSale);
              System.out.println(bookSale.toString());
              break;
            }

          case GetAllBookSales:
          {
            ArrayList<BookSale> bookSales = bookSaleDAO.getAllBookSales();
            System.out.println("SocketHandler \t:" + bookSales);

            String jsonString = new Gson().toJson(bookSales);

            byte[] array = jsonString.getBytes();
            outputStream.write(array, 0, array.length);
          }

          case GetBookSale:
          {

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
