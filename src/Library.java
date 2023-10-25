import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList<Book> books;

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Library(String name) {
        books = new ArrayList<Book>();
        this.name = name;
    }

    public Book getBookFromName(String name) {

        for (Book book : books) {

            if (name.equalsIgnoreCase(book.getName())) {
                return book;
            }

        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(Book[] books) {
        for (Book book : books) {
            this.books.add(book);
        }
    }

    public void addBook(ArrayList<Book> books) {
        for (Book book : books) {
            this.books.add(book);
        }
    }

    public void printBooks() {

        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }

    }

}