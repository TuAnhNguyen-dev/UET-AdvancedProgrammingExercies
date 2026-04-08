import java.util.*;

public class WordCounter {
    private Map<String, Integer> freq = new HashMap<>();

    // Logic chuẩn hóa văn bản
    private String standardlization(String content) {
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

    // Hàm thực thi chính: Chuẩn hóa -> Tách từ -> Đếm
    public void analyze(String content) {
        String cleanContent = standardlization(content);
        String[] words = cleanContent.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;
            // Dùng merge() cho ngắn gọn: nếu có thì cộng 1, chưa có thì gán 1
            freq.merge(word, 1, (a, b) -> a + b);
        }
    }

    // Tìm và in ra các từ xuất hiện nhiều nhất
    public void displayMostCommon() {
        int maxFreq = 0;
        List<String> mostCommon = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommon = new ArrayList<>(Collections.singletonList(entry.getKey()));
            } else if (entry.getValue() == maxFreq) {
                mostCommon.add(entry.getKey());
            }
        }
        System.out.println("\n--- Most Common Word(s) (" + maxFreq + " times) ---");
        showItem(mostCommon);
    }

    // Tìm và in ra các từ duy nhất
    public void displayUniqueWords() {
        List<String> unique = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                unique.add(entry.getKey());
            }
        }
        System.out.println("\n--- One Time Word(s) ---");
        showItem(unique);
    }

    // Hàm in danh sách hàng ngang dùng chung
    private <T> void showItem(List<T> list) {
        StringJoiner sj = new StringJoiner(", ");
        for (T item : list) sj.add(String.valueOf(item));
        System.out.println(sj.toString());
    }
}