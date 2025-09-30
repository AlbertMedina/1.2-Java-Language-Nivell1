package Level3;

public class Seat {

    private int rowNumber;
    private int seatNumber;
    private String customer;

    public Seat(int rowNumber, int seatNumber, String customer) {

        if (rowNumber <= 0) {
            throw new IllegalArgumentException("Invalid row number");
        }

        if (seatNumber <= 0) {
            throw new IllegalArgumentException("Invalid seat number");
        }

        if (customer == null || customer.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid customer");
        }

        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.customer = customer;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Seat otherSeat = (Seat) other;
        return rowNumber == otherSeat.getRowNumber() && seatNumber == otherSeat.getSeatNumber();
    }

    @Override
    public String toString() {
        return "Row: " + rowNumber + ", Seat: " + seatNumber + ", Customer: " + customer;
    }
}
