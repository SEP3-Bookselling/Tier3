package Tier3.ProtoType.DAOs.ProofOfConceptDAO;

import java.util.ArrayList;

public interface ITestDatabaseController
{
  ArrayList<String> getAllMessages();
  void insertMessage(String message);
  String getHelloWorld();
}
