package Tier3.ProtoType.Networking;

import Tier3.ProtoType.DAOs.ProofOfConceptDAO.ITestDatabaseController;
import Tier3.ProtoType.DAOs.ProofOfConceptDAO.TestDatabaseController;
import Tier3.ProtoType.TransferRequests.Request;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class DataServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inputStream;
  private ObjectOutputStream outputStream;
  private ITestDatabaseController controller; //TODO: May or may not work depending on the Interface injection stuff


  public DataServerSocketHandler(Socket socket)
  {
    this.socket = socket;

    try
    {
      inputStream = new ObjectInputStream(socket.getInputStream());
      outputStream = new ObjectOutputStream(socket.getOutputStream());

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    // TODO: Make sure the GSON file is V_2.8.2
    byte[] byteArr = new byte[1024];

    try
    {
      int arrLength = inputStream.read(byteArr,0,byteArr.length);
      String arrString = new String(byteArr,0,arrLength);

      Gson gson = new Gson();
      Request request = gson.fromJson(arrString, Request.class);

      switch (request.getRequestEnums())
      {
        case GETMESSAGEFROMDATABASE:
        {
          // String could be BookSale, but remember that all tiers have the same domain Classes (books, booksale, user etc)
          // String getMessage = gson.fromJson(request.getObject().toString(), String.class);

          // ArrayList<String> allMessages = controller.getAllMessages();
          String helloWorld = controller.getHelloWorld();
          String messagesGson = new Gson().toJson(helloWorld);

          byte[] helloWorldByteArr = messagesGson.getBytes();
          outputStream.write(helloWorldByteArr,0,helloWorldByteArr.length);

          break;
        }

        case PUTMESSAGEINTODATABASE:
        {
          String putMessage = gson.toJson(request.getObject().toString(), String.class);
          controller.insertMessage(putMessage);
          break;

        }
      }

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

}
