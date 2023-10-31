package shoppingcart;
import java.util.*;

public class Cart {
    List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        this.productList.add(product);
    }
    public void printCart() {
        productList.forEach(System.out::println);
    }
}
