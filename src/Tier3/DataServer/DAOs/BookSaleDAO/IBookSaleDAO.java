package Tier3.DataServer.DAOs.BookSaleDAO;

import Tier3.DataServer.Models.Booksale.BookSale;
import Tier3.DataServer.Models.Booksale.BookSaleNoID;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookSaleDAO
{
  ArrayList<BookSale> getAllBookSales();
  //ArrayList<String> getAllBookSales();
  //String getAllBookSales();
  BookSale getBookSale();
  void createBookSale(BookSaleNoID bookSaleNoID) throws SQLException;

}
