import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getFinalPrice();
        }
        return sum;
    }

    public void print() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
        System.out.println("Total = " + getTotal());
    }
}
