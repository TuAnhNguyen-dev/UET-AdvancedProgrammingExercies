import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("test.inp"));

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            if (type.equals("B")) {
                String author = parts[3];
                int pages = Integer.parseInt(parts[4]);
                bookSection.add(new Book(id, name, author, pages));
            } else if (type.equals("D")) {
                String director = parts[3];
                int duration = Integer.parseInt(parts[4]);
                dvdSection.add(new DVD(id, name, director, duration));
            }
        }

        System.out.println("Khu vực Sách:");
        bookSection.displaySection();

        System.out.println("\nKhu vực DVD:");
        dvdSection.displaySection();

        sc.close();
    }
}