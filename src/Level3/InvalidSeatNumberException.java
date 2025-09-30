package Level3;

public class InvalidSeatNumberException extends RuntimeException {
    public InvalidSeatNumberException() {
        super("Invalid seat number.");
    }
}
