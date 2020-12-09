package Tier3.DataServer.Models;

public class PurchaseRequest {

  public Integer requestId = null;
  public int bookSaleId;
  public String buyer;
  public String seller;



  public int getRequestId() {
    return requestId;
  }

  public int getBookSaleId() {
    return bookSaleId;
  }

  public String getBuyer() {
    return buyer;
  }

  public String getSeller() {
    return seller;
  }



  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  public void setBookSaleId(int bookSaleId) {
    this.bookSaleId = bookSaleId;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }


  @Override public String toString() {
    return "{"
        + "\"bookSale\":" + "\"" + getBookSaleId() + "\","
        + "\"buyer\":" + "\"" + getBuyer() + "\","
        + "\"seller\":" + "\"" + getSeller()
        + "}";
  }
}
