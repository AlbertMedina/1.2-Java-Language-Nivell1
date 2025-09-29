package Level1;

public class EmptySaleException extends Exception {
    public EmptySaleException() {
        super("You need to add products before making a sale.");
    }
}
