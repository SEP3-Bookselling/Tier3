package Tier3.ProtoType.TransferRequests;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestEnums requestEnums;
  private Object object;

  public RequestEnums getRequestEnums()
  {
    return requestEnums;
  }

  public void setRequestEnums(RequestEnums requestEnums)
  {
    this.requestEnums = requestEnums;
  }

  public Object getObject()
  {
    return object;
  }

  public void setObject(Object object)
  {
    this.object = object;
  }

  @Override public String toString()
  {
    return null;
  }
}
