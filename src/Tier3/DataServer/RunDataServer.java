package Tier3.DataServer;

import Tier3.DataServer.DAOs.BookSaleDAO.UserDAO;
import Tier3.DataServer.Models.User;
import Tier3.DataServer.Networking.DataServerSocket;
import Tier3.DataServer.Networking.DataServerSocketHandler;

import java.io.IOException;

public class RunDataServer
{
  public static void main(String[] args) throws IOException
  {
    DataServerSocket dataServerSocket = new DataServerSocket();

    dataServerSocket.start();


  }



}
