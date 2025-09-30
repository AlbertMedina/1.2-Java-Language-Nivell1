package Level3;

import java.util.ArrayList;
import java.util.List;

public class SeatsManagement {

    private List<Seat> bookedSeatsList;

    public SeatsManagement() {
        bookedSeatsList = new ArrayList<>();
    }

    public List<Seat> getBookedSeats() {
        return bookedSeatsList;
    }

    public void addSeat(Seat seat) {
        try {
            int seatIndex = findSeat(seat.getRowNumber(), seat.getSeatNumber());
            if (seatIndex != -1) {
                throw new BookedSeatException();
            }
            bookedSeatsList.add(seat);
            System.out.println("Seat " + seat.getRowNumber() + "-" + seat.getSeatNumber() + " booked successfully.");
        } catch (BookedSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeSeat(int rowNumber, int seatNumber) {
        try {
            int seatIndex = findSeat(rowNumber, seatNumber);
            if (seatIndex == -1) {
                throw new FreeSeatException();
            }
            bookedSeatsList.remove(seatIndex);
            System.out.println("Seat " + rowNumber + "-" + seatNumber + " booking cancelled successfully.");
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public int findSeat(int rowNumber, int seatNumber) {
        return bookedSeatsList.indexOf(new Seat(rowNumber, seatNumber, "none"));
    }
}
