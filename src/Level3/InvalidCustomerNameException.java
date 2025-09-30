package Level3;

public class InvalidCustomerNameException extends RuntimeException {
    public InvalidCustomerNameException() {
        super("Invalid customer name.");
    }
}
