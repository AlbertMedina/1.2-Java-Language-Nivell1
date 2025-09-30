package Level3;

import java.util.List;

public class CinemaManagement {

    private Cinema cinema;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public int menu() {
        System.out.println("Now we can do the following:");
        System.out.println("1. Show booked seats");
        System.out.println("2. Show seats booked by a customer");
        System.out.println("3. Book seat");
        System.out.println("4. Cancel seat booking");
        System.out.println("5. Cancel all seat bookings by customer");
        System.out.println("0. Exit");
        return InputHandler.readInt("Choose what to do next (0-5)");
    }

    public void showBookedSeats() {
        try {
            if (cinema.getSeatsManagement().getBookedSeats().isEmpty()) {
                throw new Exception("No seats booked for the time being.");
            }
            for (Seat s : cinema.getSeatsManagement().getBookedSeats()) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showBookedSeatsPerCustomer() {
        try {
            String customer = enterCustomer();
            List<Seat> seatsByCustomer = getSeatsByCustomer(customer);
            if (seatsByCustomer.isEmpty()) {
                throw new Exception("No seats booked by this costumer.");
            }
            for (Seat seat : seatsByCustomer) {
                System.out.println(seat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bookSeat() {
        int rowNumber = enterRowNumber();
        int seatNumber = enterSeatNumber();
        String customer = enterCustomer();
        cinema.getSeatsManagement().addSeat(new Seat(rowNumber, seatNumber, customer));
    }

    public void cancelBooking() {
        int rowNumber = enterRowNumber();
        int seatNumber = enterSeatNumber();
        cinema.getSeatsManagement().removeSeat(rowNumber, seatNumber);
    }

    public void cancelAllBookingsByCustomer() {
        try {
            String customer = enterCustomer();
            List<Seat> seatsByCustomer = getSeatsByCustomer(customer);
            if (seatsByCustomer.isEmpty()) {
                throw new Exception("No seats booked by this customer.");
            }
            for (Seat seat : seatsByCustomer) {
                cinema.getSeatsManagement().removeSeat(seat.getRowNumber(), seat.getSeatNumber());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String enterCustomer() {
        while (true) {
            try {
                String customerName = InputHandler.readString("Enter customer name");
                if (customerName.matches(".*\\d.*")) {
                    throw new InvalidCustomerNameException();
                }
                return customerName;
            } catch (InvalidCustomerNameException e) {
                System.out.println(e.getMessage() + " The customer name cannot contain numbers.");
            }
        }
    }

    private int enterRowNumber() {
        while (true) {
            try {
                int rowNumber = InputHandler.readInt("Enter row number");
                if (rowNumber < 1 || rowNumber > cinema.getNumberOfRows()) {
                    throw new InvalidRowNumberException();
                }
                return rowNumber;
            } catch (InvalidRowNumberException e) {
                System.out.println(e.getMessage() + " The number must be between 1 and " + cinema.getNumberOfRows() + ".");
            }
        }
    }

    private int enterSeatNumber() {
        while (true) {
            try {
                int seatNumber = InputHandler.readInt("Enter seat number");
                if (seatNumber < 1 || seatNumber > cinema.getNumberOfSeatsPerRow()) {
                    throw new InvalidSeatNumberException();
                }
                return seatNumber;
            } catch (InvalidSeatNumberException e) {
                System.out.println(e.getMessage() + " The number must be between 1 and " + cinema.getNumberOfSeatsPerRow() + ".");
            }
        }
    }

    private List<Seat> getSeatsByCustomer(String customer) {
        return cinema.getSeatsManagement().getBookedSeats().stream().filter(s -> s.getCustomer().equalsIgnoreCase(customer)).toList();
    }
}
