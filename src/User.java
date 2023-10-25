import java.util.ArrayList;

public class User {

    private String name;
    private double balance;
    private ArrayList<Book> booksOwned;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Book> getBooksOwned() {
        return booksOwned;
    }

    public User(String name, double balance) {
        booksOwned = new ArrayList<Book>();
        this.name = name;
        this.balance = balance;
    }

    public void addBook(Book book) {
        booksOwned.add(book);
    }

    public void addBook(Book[] books) {
        for (Book book : books) {
            booksOwned.add(book);
        }
    }

    public void addBook(ArrayList<Book> books) {
        for (Book book : books) {
            booksOwned.add(book);
        }
    }

    public void removeBook(Book book) {
        booksOwned.remove(book);
    }

    public void printBooksOwned() {

        if (booksOwned.isEmpty()) {
            System.out.println(Base.RED + "You don't own any books." + Base.RESET);
            return;
        }

        for (Book book : booksOwned) {
            System.out.println(book);
            System.out.println();
        }

    }

}