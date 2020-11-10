package Tier3.ProtoType.Networking;

import Tier3.ProtoType.DAOs.ProofOfConceptDAO.ITestDatabaseController;
import Tier3.ProtoType.DAOs.ProofOfConceptDAO.TestDatabaseController;
import Tier3.ProtoType.TransferRequests.Request;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.Socket;

public class DataServerSocketHandler implements Runnable
{
  private Socket socket;
  //private ObjectInputStream inputStream;
  //private ObjectOutputStream outputStream;
  private InputStream inputStream;
  private OutputStream outputStream;
  private ITestDatabaseController controller; //TODO: May or may not work depending on the Interface injection stuff
  private Gson gson;

  public DataServerSocketHandler(Socket socket)
  {
    this.socket = socket;
    gson = new Gson();
    controller = new TestDatabaseController();

    try
    {
      //inputStream = new ObjectInputStream(socket.getInputStream());
      inputStream = socket.getInputStream();
      //outputStream = new ObjectOutputStream(socket.getOutputStream());
      outputStream = socket.getOutputStream();


    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    // TODO: Make sure the GSON file is V_2.8.2
    //while (true)
    //{
      byte[] byteArr = new byte[1024];

      try
      {
        int arrLength = inputStream.read(byteArr, 0, byteArr.length);
        String arrString = new String(byteArr, 0, arrLength);
        //System.out.println(arrLength);

        Request request = gson.fromJson(arrString, Request.class);

        switch (request.getRequestEnum())
        {
          case recieveProofOfConcept:
          {
            // String could be BookSale, but remember that all tiers have the same domain Classes (books, booksale, user etc)
            // String getMessage = gson.fromJson(request.getObject().toString(), String.class);

            // ArrayList<String> allMessages = controller.getAllMessages();
            //String helloWorld = controller.getHelloWorld();
            //String messagesGson = new Gson().toJson(helloWorld);
            //String fromDatabase = new Gson().toJson(request.getStringToBeSend());

            String fromDatabase = new Gson().toJson(controller.getHelloWorld());
            byte[] array = fromDatabase.getBytes();
            System.out.println(fromDatabase.toString());
            outputStream.write(array, 0, array.length);

            break;
          }

          case sendProofOfConcept:
          {
            // IT WOOOOOOOORKS Den får dog en conncetion Reset på første forsøg?
             //String putMessage = gson.toJson(request.getObject().toString(), String.class);
            //String putMessage = gson.toJson(request.getStringToBeSend(), String.class);
            //String putMessage = gson.fromJson(request.getStringToBeSend(), String.class);
            JsonReader reader = new JsonReader(new StringReader(request.getStringToBeSend()));
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
    //}
  }

}
