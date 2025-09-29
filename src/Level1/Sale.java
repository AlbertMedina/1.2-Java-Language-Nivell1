package Level1;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private List<Product> productsList;
    private double totalPrice;

    public Sale() {
        productsList = new ArrayList<>();
        totalPrice = 0;
    }

    public double calculateTotalPrice() throws EmptySaleException {
        if (productsList.isEmpty()) {
            throw new EmptySaleException();
        }
        totalPrice = productsList.stream().mapToDouble(Product::getPrice).sum();
        return totalPrice;
    }

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public Product getProductAtIndex(int index) {
        return productsList.get(index);
    }
}
