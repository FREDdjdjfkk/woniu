package entity;

public class Book {
    private int UUID;
    private String Bookname;

    private String Author;

    private  String publisher;
    private  double price;

    public Book() {
    }

    public Book(int UUID, String bookname, String author, String publisher, double price) {
        this.UUID = UUID;
        Bookname = bookname;
        Author = author;
        this.publisher = publisher;
        this.price = price;

    }

    public int getUUID() {
        return UUID;
    }

    public String getAuthor() {
        return Author;
    }

    public String getBookname() {
        return Bookname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "UUID=" + UUID +
                ", Bookname='" + Bookname + '\'' +
                ", Author='" + Author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}



