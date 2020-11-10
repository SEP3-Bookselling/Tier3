package Tier3.ProtoType.TransferRequests;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestEnum requestEnum;
  private Object objectToBeSend;
  private String stringToBeSend;

  public RequestEnum getRequestEnum()
  {
    return requestEnum;
  }

  public void setRequestEnum(RequestEnum requestEnum)
  {
    this.requestEnum = requestEnum;
  }

  public Object getObjectToBeSend()
  {
    return objectToBeSend;
  }

  public void setObjectToBeSend(Object objectToBeSend)
  {
    this.objectToBeSend = objectToBeSend;
  }

  @Override public String toString()
  {
    return null;
  }

  public String getStringToBeSend()
  {
    return stringToBeSend;
  }

  public void setStringToBeSend(String stringToBeSend)
  {
    this.stringToBeSend = stringToBeSend;
  }
}
