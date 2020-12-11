package Tier3.DataServer.TransferRequests;

public enum EnumRequest
{

  //BookSale
  CreateBookSale,
  GetAllBookSales,
  UpdateBookSale,
  DeleteBookSale,

  //Users
  CreateUser,
  GetSpecificUserLogin,
  GetUserList,
  UpdateUser,
  DeleteUser,

  //Customers
  CreateCustomer,
  GetSpecificCustomer,
  UpdateCustomer,
  DeleteCustomer,
  GetRatings,
  Rate,

  //PurchaseRequest
  CreatePurchaseRequest,
  GetPurchaseRequest,
  GetPurchaseRequestFromId,
  DeletePurchaseRequest,


  // Prototype
  recieveProofOfConcept,
  sendProofOfConcept
}
