public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println("Stock of Java Backend: " + bookStore.getStock("Java Backend"));
            }).start();
        }

        new Thread(() -> {
            bookStore.addBook("Java Backend", 5);
            System.out.println("Added 5 Java Backend books");
        }).start();

        new Thread(() -> {
            bookStore.borrowBook("Java Backend", 3);
            System.out.println("Borrowed 3 Java Backend books");
        }).start();
    }
}
