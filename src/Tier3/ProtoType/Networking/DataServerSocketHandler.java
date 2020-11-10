package Tier3.ProtoType.Networking;

import Tier3.ProtoType.DAOs.ProofOfConceptDAO.ITestDatabaseController;
import Tier3.ProtoType.DAOs.ProofOfConceptDAO.TestDatabaseController;
import Tier3.ProtoType.TransferRequests.Request;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class DataServerSocketHandler implements Runnable
{
  private Socket socket;

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

}
