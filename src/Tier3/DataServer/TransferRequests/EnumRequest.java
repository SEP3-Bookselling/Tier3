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
  GetAllUsers,
  UpdateUser,
  DeleteUser,
  RateUser,

  //Customers
  CreateCustomer,
  GetCustomer,
  UpdateCustomer,
  DeleteCustomer,

  // Prototype
  recieveProofOfConcept,
  sendProofOfConcept
}
