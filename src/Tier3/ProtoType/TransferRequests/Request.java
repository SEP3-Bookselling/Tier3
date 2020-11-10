package Tier3.ProtoType.TransferRequests;

import java.io.Serializable;

public class Request implements Serializable
{
  private EnumRequest EnumRequest;
  private Object ob;
  private String HelloWorld;

  public EnumRequest getEnumRequest()
  {
    return EnumRequest;
  }

  public void setEnumRequest(EnumRequest enumRequest)
  {
    this.EnumRequest = enumRequest;
  }

  public Object getOb()
  {
    return ob;
  }

  public void setOb(Object ob)
  {
    this.ob = ob;
  }

  @Override public String toString()
  {
    return null;
  }

  public String getHelloWorld()
  {
    return HelloWorld;
  }

  public void setHelloWorld(String helloWorld)
  {
    this.HelloWorld = helloWorld;
  }
}
