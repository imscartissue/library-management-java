import java.util.ArrayList;
import java.util.Scanner;

public class Base extends Thread {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    private static Scanner scanner = new Scanner(System.in);
    private static Library library;
    private static User user;

    public synchronized void start() {

        library = new Library("Osprey");
        user = new User("John", 50.0);
        addBooks();

        promptMessage();

        Clock clock = new Clock();
        clock.start();

        do {

            String input = getInput();
            checkInput(input);

        } while (true);

    }

    private static void promptMessage() {

        System.out.println(GREEN + "Welcome to the " + YELLOW + library.getName() + GREEN + " library!" + RESET);
        System.out.println(BLACK + "----------------------------------------------------------------------------------------------------");

        System.out.println(YELLOW + "Here are a few commands to help you get started:" + RESET);
        System.out.println();

        helpMessage();
        System.out.println();

        System.out.println(RED + "Note: When purchasing a new book, there is no upfront cost, but a daily tax of Rs. 5 applies. If the number of days exceeds 15, the tax increases to Rs. 10. Similarly, if the number of days exceeds 30, it becomes Rs. 15, and so on. If you forget to pay the tax, we will automatically deduct the amount from your bank balance. If you don't have the necessary funds, the book will be automatically reclaimed." + RESET);

        System.out.println(BLACK + "----------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void helpMessage() {

        System.out.println(YELLOW + "1." + GREEN + " display-books " + YELLOW + "--->" + GREEN + " Displays all the available books.");
        System.out.println(YELLOW + "2." + GREEN + " display-owned " + YELLOW + "--->" + GREEN + " Displays all the books owned by you.");
        System.out.println(YELLOW + "3." + GREEN + " book [bookName] " + YELLOW + "--->" + GREEN + " Displays the book's information.");
        System.out.println(YELLOW + "4." + GREEN + " buy [bookName] " + YELLOW + "--->" + GREEN + " Use this command to buy a book.");
        System.out.println(YELLOW + "5." + GREEN + " pay [bookName] " + YELLOW + "--->" + GREEN + " Use this command to pay for a book.");
        System.out.println(YELLOW + "6." + GREEN + " return [bookName] " + YELLOW + "--->" + GREEN + " Use this command to return a book.");
        System.out.println();
        System.out.println(RED + "7." + GREEN + " help " + RED + "--->" + GREEN + " Displays the command list.");
        System.out.println(RED + "8." + GREEN + " balance " + RED + "--->" + GREEN + " Displays your balance." + RESET);

    }

    private static String getInput() {
        System.out.println();
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    private static void checkInput(String input) {

        if (input.startsWith("book ")) {

            String afterBook = input.substring(5);

            for (Book book : library.getBooks()) {

                String name = book.getName();
                if (name.equalsIgnoreCase(afterBook)) {
                    System.out.println(book);
                    return;
                }
            }
            System.out.println(RED + "The book with the name of " + YELLOW + afterBook + RED + " doesn't exist." + RESET);
            return;

        }




        if (input.startsWith("buy ")) {

            String afterBuy = input.substring(4);

            for (Book book : library.getBooks()) {

                String name = book.getName();
                if (name.equalsIgnoreCase(afterBuy)) {

                    Book bookToBuy = library.getBookFromName(name);
                    user.addBook(bookToBuy);

                    System.out.println(GREEN + "You took the book " + YELLOW + book.getName() + GREEN + " from the library." + RESET);
                    return;

                }

            }
            System.out.println(RED + "The book with the name of " + YELLOW + afterBuy + RED + " doesn't exist." + RESET);
            return;

        }


        // Need to work on this
        if (input.startsWith("pay ")) {

            String afterPay = input.substring(4);

            for (Book book : library.getBooks()) {

                String name = book.getName();
                if (name.equalsIgnoreCase(afterPay)) {

                    Book bookToPay = library.getBookFromName(name);
                    System.out.println(GREEN + "You took the book " + YELLOW + book.getName() + GREEN + " from the library." + RESET);
                    return;

                }

            }
            System.out.println(RED + "The book with the name of " + YELLOW + afterPay + RED + " doesn't exist." + RESET);
            return;

        }




        if (input.startsWith("return ")) {

            String afterReturn = input.substring(7);

            for (Book book : library.getBooks()) {

                String name = book.getName();
                if (name.equalsIgnoreCase(afterReturn)) {

                    Book bookToReturn = library.getBookFromName(name);
                    user.removeBook(bookToReturn);
                    System.out.println(GREEN + "You returned the book " + YELLOW + book.getName() + GREEN + " to the library." + RESET);
                    return;

                }

            }
            System.out.println(RED + "The book with the name of " + YELLOW + afterReturn + RED + " doesn't exist." + RESET);
            return;

        }





        switch (input) {

            case "display-books":
                library.printBooks();
                break;
            case "display-owned":
                user.printBooksOwned();
                break;
            case "balance":
                System.out.println(CYAN + "Your current balance: " + GREEN + user.getBalance() + RESET);
                break;
            case "quit":
                System.exit(0);
            case "help":
                helpMessage();
                break;
            default:
                System.out.println(RED + "The command " + YELLOW + input + RED +  " doesn't exist. Use 'help' to view the command list." + RESET);
                break;

        }

    }

    private static void parameterCommands() {

    }

    private static void addBooks() {

        ArrayList<Book> books = new ArrayList<Book>();

        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 109);
        Book book2 = new Book("1984", "George Orwell", 240);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", 120);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 655);
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", 510);
        Book book6 = new Book("Moby-Dick", "Herman Melville", 780);
        Book book7 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 120);
        Book book8 = new Book("War and Peace", "Leo Tolstoy", 540);
        Book book9 = new Book("The Hobbit", "J.R.R. Tolkien", 889);
        Book book10 = new Book("Brave New World", "Aldous Huxley", 654);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        library.addBook(books);

    }

}