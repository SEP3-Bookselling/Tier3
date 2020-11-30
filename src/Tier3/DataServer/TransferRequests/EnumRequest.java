package Tier3.DataServer.TransferRequests;

public enum EnumRequest
{
  // Creating new objects in database
  CreateBookSaleNoID,
  CreateUser,
  CreateCustomer,

  // Getting from database
  GetAllBookSales,
  GetBookSale,
  GetUser,
  GetCustomer,
  GetCard,

  // Selling Book
  SellBook,

  // Deleting objects from database
  DeleteSale,
  DeleteUser,
  DeleteCard,

  // Rate user
  RateUser,

  // Prototype
  recieveProofOfConcept,
  sendProofOfConcept
}
