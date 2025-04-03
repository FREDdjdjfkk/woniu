package test;

import Impl.BookServiceImpl;
import entity.Book;
import entity.BookService;

public class TestBook {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();

        // 添加图书
        bookService.addBook(new Book(1,"Java编程思想", "Bruce Eckel", "机械工业出版社", 99.00));
        bookService.addBook(new Book(2,"深入理解Java虚拟机", "周志明", "机械工业出版社", 89.00));
        bookService.addBook(new Book(3,"Java核心技术", "Cay S. Horstmann", "机械工业出版社", 79.00));

        // 查询所有图书
        System.out.println("所有图书:");
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }

        // 根据书名删除图书
        bookService.removeBookByTitle("Java核心技术");
        System.out.println("删除后图书列表:");
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }

        // 根据书名查找图书
        System.out.println("查找 Java编程思想:");
        for (Book book : bookService.findBooksByTitle("Java编程思想")) {
            System.out.println(book);
        }
    }
    }


