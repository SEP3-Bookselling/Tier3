package Tier3.DataServer.Models;

public class PurchaseRequest {

  public int requestId;
  public BookSale bookSale;
  public String buyer;
  public String seller;



  public int getRequestId() {
    return requestId;
  }

  public BookSale getBookSale() {
    return bookSale;
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

  public void setBookSale(BookSale bookSale) {
    this.bookSale = bookSale;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }

  
  @Override public String toString() {
    return "PurchaseRequest{" + "requestId=" + requestId + ", bookSale="
        + bookSale + ", buyer='" + buyer + '\'' + ", seller='" + seller + '\''
        + '}';
  }
}
