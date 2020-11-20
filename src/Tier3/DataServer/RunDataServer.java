package Tier3.DataServer;

import Tier3.DataServer.Networking.DataServerSocket;

import java.io.IOException;

public class RunDataServer
{
  public static void main(String[] args) throws IOException
  {
    DataServerSocket dataServerSocket = new DataServerSocket();
    dataServerSocket.start();
  }
}
