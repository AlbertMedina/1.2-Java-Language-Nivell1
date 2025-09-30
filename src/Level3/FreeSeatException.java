package Level3;

public class FreeSeatException extends RuntimeException {
    public FreeSeatException() {
        super("This seat is not booked.");
    }
}
