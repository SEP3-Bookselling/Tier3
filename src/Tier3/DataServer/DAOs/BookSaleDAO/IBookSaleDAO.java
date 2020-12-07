package Tier3.DataServer.DAOs.BookSaleDAO;

import Tier3.DataServer.Models.Booksale.BookSale;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookSaleDAO
{
  ArrayList<BookSale> getAllBookSales(String username);
  void createBookSale(BookSale bookSale) throws SQLException;
  void updateBookSale(BookSale sale);
  void deleteBookSale(int id);

}
