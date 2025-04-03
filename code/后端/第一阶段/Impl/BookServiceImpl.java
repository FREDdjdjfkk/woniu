package Impl;

import entity.Book;
import entity.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public boolean removeBookByTitle(String title) {
        return books.removeIf(book -> book.getBookname().equalsIgnoreCase(title));
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookname().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
}
