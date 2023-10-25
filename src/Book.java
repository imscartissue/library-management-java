public class Book {

    private String name;
    private String author;
    private int numberOfPages;
    private int currentPrice;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Book(String name, String author, int numberOfPages) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void increasePrice() {
        this.currentPrice += 5;
    }

    @Override
    public String toString() {
        String bookInfo = String.format(Base.CYAN + "Book name: " + Base.YELLOW + " %s\n" + Base.CYAN + "Book author: " + Base.YELLOW + "%s\n" + Base.CYAN + "Number Of Pages:" + Base.YELLOW + " %d" + Base.RESET, this.name, this.author, this.numberOfPages);
        return bookInfo;
    }

}