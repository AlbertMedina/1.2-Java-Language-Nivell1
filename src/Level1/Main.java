package Level1;

public class Main {
    public static void main(String[] args) {

        Sale sale = new Sale();

        // empty sale
        showSaleTotalPrice(sale);

        System.out.println();

        // adding some products
        addProduct(sale, "Water", 0.99);
        addProduct(sale, "Chips", 2.49);
        showSaleTotalPrice(sale);

        System.out.println();

        // showing product at index 1
        showProductAtIndex(sale, 1);

        System.out.println();

        // showing product at index 3 (index out of bounds)
        showProductAtIndex(sale, 3);
    }

    private static void showSaleTotalPrice(Sale sale) {
        try {
            System.out.println(String.format("Sale total price: %.2f €", sale.calculateTotalPrice()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addProduct(Sale sale, String name, double price) {
        try {
            sale.addProduct(new Product(name, price));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private static void showProductAtIndex(Sale sale, int index) {
        try {
            System.out.println("Product at index " + index + ": " + sale.getProductAtIndex(index).toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
