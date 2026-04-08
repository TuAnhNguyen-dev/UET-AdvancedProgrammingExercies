import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listLib = new ArrayList<>();
        Map<String, Book> hashLib = new HashMap<>();
        Map<String, Book> treeLib = new TreeMap<>();

        // Dữ liệu mẫu
        Book[] sample = {
                new Book("B03", "Java Core", "James", 2020),
                new Book("B01", "Python Basics", "Guido", 2018),
                new Book("B05", "C++ Advanced", "Bjarne", 2022),
                new Book("B02", "Clean Code", "Uncle Bob", 2008),
                new Book("B04", "Algorithms", "Sedgewick", 2011)
        };

        // Thêm sách vào 3 cấu trúc dữ liệu
        for (Book b : sample) {
            listLib.add(b);
            hashLib.put(b.id, b);
            treeLib.put(b.id, b);
        }

        // tìm kiếm
        String searchId = "B02";
        // ArrayList: Phải dùng loop
        for (Book b : listLib) {
            if (b.id.equals(searchId)) { /* Found */ break; }
        }
        // Map: Gọi phát có luôn
        Book foundHash = hashLib.get(searchId);
        Book foundTree = treeLib.get(searchId);

        // Xóa sách
        String removeId = "B01";
        listLib.removeIf(b -> b.id.equals(removeId));
        hashLib.remove(removeId);
        treeLib.remove(removeId);

        // In danh sách
        System.out.println("--- ArrayList (Thứ tự thêm vào) ---");
        listLib.forEach(System.out::println);

        System.out.println("\n--- HashMap (Thứ tự ngẫu nhiên) ---");
        hashLib.values().forEach(System.out::println);

        System.out.println("\n--- TreeMap (Tự động sắp xếp theo ID) ---");
        treeLib.values().forEach(System.out::println);
    }
}