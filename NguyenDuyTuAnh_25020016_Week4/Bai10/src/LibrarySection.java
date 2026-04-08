import java.util.ArrayList;
import java.util.List;

public class LibrarySection<T extends MediaItem> {
    private List<T> items;

    public LibrarySection() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public void displaySection() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}