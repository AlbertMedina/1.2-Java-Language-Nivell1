package Level3;

public class Cinema {

    private int numberOfRows;
    private int numberOfSeatsPerRow;
    private CinemaManagement cinemaManagement;
    private SeatsManagement seatsManagement;

    public Cinema() {
        cinemaManagement = new CinemaManagement(this);
        seatsManagement = new SeatsManagement();
        askForInitialInfo();
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfSeatsPerRow() {
        return numberOfSeatsPerRow;
    }

    public CinemaManagement getCinemaManagement() {
        return cinemaManagement;
    }

    public SeatsManagement getSeatsManagement() {
        return seatsManagement;
    }

    private void askForInitialInfo() {
        System.out.println("Welcome to the cinema!");
        numberOfRows = enterPositiveInteger("Enter the number of rows");
        numberOfSeatsPerRow = enterPositiveInteger("Enter the number of seats per row");
        System.out.println();
    }

    public void start() {
        int option;
        do {
            option = cinemaManagement.menu();
            switch (option) {
                case 1:
                    cinemaManagement.showBookedSeats();
                    break;
                case 2:
                    cinemaManagement.showBookedSeatsPerCustomer();
                    break;
                case 3:
                    cinemaManagement.bookSeat();
                    break;
                case 4:
                    cinemaManagement.cancelBooking();
                    break;
                case 5:
                    cinemaManagement.cancelAllBookingsByCustomer();
                    break;
                case 0:
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("Invalid option (" + option + ").");
                    break;
            }
            System.out.println();
        } while (option != 0);
    }

    public static int enterPositiveInteger(String message) {
        while (true) {
            try {
                int input = InputHandler.readInt(message);
                if (input <= 0) {
                    throw new Exception("Format error.");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Enter a valid number (greater than 0).");
            }
        }
    }
}
