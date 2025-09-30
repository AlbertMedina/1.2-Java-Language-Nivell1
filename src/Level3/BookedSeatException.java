package Level3;

public class BookedSeatException extends RuntimeException {
    public BookedSeatException() {
        super("This seat is already booked.");
    }
}
