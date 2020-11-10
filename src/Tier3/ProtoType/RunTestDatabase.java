package Tier3.ProtoType;

import Tier3.ProtoType.DAOs.ProofOfConceptDAO.TestDatabaseController;
import Tier3.ProtoType.Networking.DataServerSocket;

import java.io.IOException;

public class RunTestDatabase
{
  public static void main(String[] args) throws IOException
  {
    DataServerSocket dataServerSocket = new DataServerSocket();
    dataServerSocket.start();



    // This stuff won't run since the the code above is stuck in a while true loop
    TestDatabaseController testDatabaseController = new TestDatabaseController();
    String message = "Hello!";

    testDatabaseController.insertMessage(message);
    //testDatabase.getAllMessages();

    System.out.println(testDatabaseController.getAllMessages());
  }
}
