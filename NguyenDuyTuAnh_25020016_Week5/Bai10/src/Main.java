import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = sc.nextLine();

        Map<String, String> configMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Bỏ qua các dòng trống hoặc không có dấu '='
                if (line.trim().isEmpty() || !line.contains("=")) {
                    continue;
                }

                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String val = parts[1].trim();

                configMap.put(key, val);
            }

            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Missing username");
            }
            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Missing timeout");
            } else {
                int timeOut = Integer.parseInt(configMap.get("timeout"));
                if (timeOut <= 0) {
                    throw new InvalidConfigException("timeOut must be > 0");
                }
            }

            if (configMap.containsKey("maxConnections")) {
                int maxConn = Integer.parseInt(configMap.get("maxConnections"));
                if (maxConn < 1) {
                    throw new InvalidConfigException("maxConnections must be >= 1");
                }
            }

            System.out.println("\n--- Cấu hình đọc được ---");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("\nConfig loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đóng file!");
            }
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
