package entity;

import java.util.List;

public interface BookService  {
   public void addBook(Book book);
   public List<Book> getAllBooks();
   public boolean removeBookByTitle(String title);
   public List<Book> findBooksByTitle(String title);



}



