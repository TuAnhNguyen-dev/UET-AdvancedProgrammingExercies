import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Đọc file
        Scanner sc = new Scanner(new File("input.txt"));
        StringBuilder inputString = new StringBuilder();
        while (sc.hasNextLine()) {
            inputString.append(sc.nextLine()).append('\n');
        }
        sc.close();

        // 2. Sử dụng WordCounter
        WordCounter counter = new WordCounter();

        System.out.println("--- Base Content ---");
        System.out.println(inputString.toString().trim());

        // Chạy phân tích
        counter.analyze(inputString.toString());

        // Hiển thị kết quả
        counter.displayMostCommon();
        counter.displayUniqueWords();
    }
}