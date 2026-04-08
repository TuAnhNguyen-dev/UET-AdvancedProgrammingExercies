import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public String standardlization(String content) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isWhitespace(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public <T> void showItem(List<T> list) {
        StringJoiner sj = new StringJoiner(", "); // Dấu phẩy và khoảng trắng làm phân cách
        for (T item : list) {
            sj.add(String.valueOf(item));
        }
        System.out.println(sj.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        StringBuilder inputString = new StringBuilder();
        Main obj = new Main();

        while (sc.hasNextLine()) {
            inputString.append(sc.nextLine()).append('\n');
        }

        String content = inputString.toString().trim();

        System.out.println(" ---Base Content---");
        System.out.println(content);

        content = obj.standardlization(content);
        System.out.println("\n\n ---After Remove and Lower Letter---");
        System.out.println(content);

        String[] words = content.split("\\s+");

        HashMap<String, Integer> freq = new HashMap<>();
        for (String word: words) {
            if (freq.containsKey(word)) {
                freq.put(word, freq.get(word) + 1);
            } else {
                freq.put(word, 1);
            }
        }

        int mostFreq = 0;
        List<String> mostCommonWords = new ArrayList<>();
        List<String> oneTimeWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            int appearTime = entry.getValue();
            String s = entry.getKey();

            if (appearTime > mostFreq) {
                mostCommonWords = new ArrayList<>();
                mostCommonWords.add(s);
                mostFreq = appearTime;
            } else if (appearTime == mostFreq) {
                mostCommonWords.add(s);
            }

            if (appearTime == 1) {
                oneTimeWords.add(s);
            }
        }

        System.out.println("\n ---Most Common Word(s)---");
        obj.showItem(mostCommonWords);

        System.out.print("\n ---One Time Word(s)---");
        obj.showItem(oneTimeWords);
    }
}
