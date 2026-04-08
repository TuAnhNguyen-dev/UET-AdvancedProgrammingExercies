public class Book {
    String id, title, author;
    int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d)", id, title, author, year);
    }
}