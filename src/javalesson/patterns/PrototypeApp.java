package javalesson.patterns;

public class PrototypeApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book("Ночной Дозор", "Лукьяненко", 350);
        System.out.println(book1);
        BookFactory factory = new BookFactory(book1);
        Book book2 = factory.makeCopy();
        System.out.println(book2);
    }
}

interface Copyable{
    Object copy();
}
class Book implements Copyable{
    private String name;
    private String author;
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Override
    public Object copy() {
        Book book = new Book(name, author, pages);
        return book;
    }
}
class BookFactory{
    Book book;

    public BookFactory(Book book) {
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    Book makeCopy(){
        return (Book) book.copy();
    }
}