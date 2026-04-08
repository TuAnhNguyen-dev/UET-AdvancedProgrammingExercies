import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends Product> {
    private List<T> items;

    public Warehouse() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void printInventory() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}
