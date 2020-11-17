package Tier3.DataServer.DAOs.BookSaleDAO;

import Tier3.DataServer.Models.BookSale;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookSaleDAO
{
  //ArrayList<BookSale> getAllBookSales();
  //ArrayList<String> getAllBookSales();
  String getAllBookSales();
  BookSale getBookSale();
  void createBookSale(BookSale bookSale) throws SQLException;

}
