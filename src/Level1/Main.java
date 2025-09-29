package Level1;

public class Main {
    public static void main(String[] args) {

        Sale sale = new Sale();

        // empty sale
        showSaleTotalPrice(sale);

        System.out.println();

        // adding some products
        sale.addProduct(new Product("Water", 0.99));
        sale.addProduct(new Product("Chips", 2.49));
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

    private static void showProductAtIndex(Sale sale, int index) {
        try {
            System.out.println("Product at index " + index + ": " + sale.getProductAtIndex(index).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
