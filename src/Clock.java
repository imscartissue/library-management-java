public class Clock extends Thread {

    private static int numberOfDaysPassed;
    private static boolean newDay;

    public static int getNumberOfDaysPassed() {
        return numberOfDaysPassed;
    }

    public static boolean getNewDay() {
        return newDay;
    }

    public void setNewDay(boolean newDay) {
        this.newDay = newDay;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(10000);
                newDay = true;
                System.out.println();
                System.out.println(Base.BLACK + "----------------------------------------------------------------------------------------------------");
                System.out.println(Base.PURPLE + "Day " + Base.YELLOW + numberOfDaysPassed + Base.PURPLE + " complete.");
                System.out.println(Base.BLACK + "----------------------------------------------------------------------------------------------------" + Base.RESET);
                System.out.println();
                numberOfDaysPassed++;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}