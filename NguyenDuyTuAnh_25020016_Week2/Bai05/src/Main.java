public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "John", 10.5);
        Book b2 = new Book("Java Basics", "John", 10.5);

        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2));
    }
}