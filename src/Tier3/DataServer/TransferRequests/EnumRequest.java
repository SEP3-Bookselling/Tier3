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
  GetSpecificUserLogin,
  GetUserList,
  GetAllUsers,
  UpdateUser,
  DeleteUser,

  //Customers
  CreateCustomer,
  GetSpecificCustomer,
  UpdateCustomer,
  DeleteCustomer,
  GetRatings,
  Rate,

  // Prototype
  recieveProofOfConcept,
  sendProofOfConcept
}
