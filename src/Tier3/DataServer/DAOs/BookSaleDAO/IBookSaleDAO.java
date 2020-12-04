package Tier3.DataServer.DAOs.BookSaleDAO;

import Tier3.DataServer.Models.Booksale.BookSale;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookSaleDAO
{
  ArrayList<BookSale> getAllBookSales(String username);
  //ArrayList<String> getAllBookSales();
  //String getAllBookSales();
  BookSale getBookSale();
  void createBookSale(BookSale bookSale) throws SQLException;
  void deleteBookSale(int id);

}
