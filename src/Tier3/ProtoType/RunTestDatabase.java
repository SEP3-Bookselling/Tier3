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

  }
}
