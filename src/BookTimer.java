public class BookTimer {

    private Book book;
    private int numberOfDaysPassed;
    private Clock clock;

    public BookTimer(Book book) {
        this.book = book;
        clock = new Clock();
        start();
    }

    private synchronized void start() {

        do {

            if (Clock.getNewDay()) {
                numberOfDaysPassed++;
                clock.setNewDay(false);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (numberOfDaysPassed % 15 == 1) {
                book.increasePrice();
                System.out.println(Base.RED + "You'll have to pay " + Base.GREEN + "Rs. " + book.getCurrentPrice() + Base.RED + " for the book " + Base.YELLOW + book.getName() + Base.RED + " starting today.");
            }

        } while (true);

    }

}