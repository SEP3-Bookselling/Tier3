package Tier3.Prototype;

import Tier3.Prototype.DAOs.ProofOfConceptDAO.TestDatabaseController;
import Tier3.Prototype.Networking.DataServerSocket;

import java.io.IOException;

public class RunTestDatabase
{
  public static void main(String[] args) throws IOException
  {
    DataServerSocket dataServerSocket = new DataServerSocket();
    dataServerSocket.start();



    TestDatabaseController testDatabaseController = new TestDatabaseController();
    String message = "Hello!";

    testDatabaseController.insertMessage(message);
    //testDatabase.getAllMessages();

    System.out.println(testDatabaseController.getAllMessages());
  }
}
