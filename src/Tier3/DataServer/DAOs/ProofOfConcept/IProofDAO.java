package Tier3.DataServer.DAOs.ProofOfConcept;

import java.util.ArrayList;

public interface IProofDAO
{
  ArrayList<String> getAllMessages();
  void insertMessage(String message);
  String getHelloWorld();
}
