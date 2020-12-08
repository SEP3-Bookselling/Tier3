package Tier3.DataServer.TransferRequests;

public enum EnumRequest
{

  //BookSale
  CreateBookSale,
  GetBookSpecificBookSale,
  GetAllBookSales,
  UpdateBookSale,
  DeleteBookSale,

  //Users
  CreateUser,
  GetSpecificUser,
  GetUserList,
  GetAllUsers,
  UpdateUser,
  DeleteUser,
  RateUser,

  //Customers
  CreateCustomer,
  GetSpecificCustomer,
  UpdateCustomer,
  DeleteCustomer,

  //PurchaseRequest
  CreateRequest,
  GetRequest,
  DeleteRequest,


  // Prototype
  recieveProofOfConcept,
  sendProofOfConcept
}
