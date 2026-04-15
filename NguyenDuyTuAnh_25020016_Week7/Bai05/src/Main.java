import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")))) {
            // Đọc số lượng đơn hàng từ dòng đầu tiên
            int n = Integer.parseInt(reader.readLine().trim());
            
            // Danh sách lưu các OrderProcessor task
            List<Callable<Boolean>> tasks = new ArrayList<>();
            List<String> sharedLogs = new ArrayList<>();
            AtomicInteger successCount = new AtomicInteger(0);
            
            // Đọc các đơn hàng
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 2) {
                    String orderId = parts[0];
                    long processMs = Long.parseLong(parts[1]);
                    
                    // Tạo OrderProcessor task
                    OrderProcessor processor = new OrderProcessor(orderId, processMs, sharedLogs, successCount);
                    tasks.add(processor);
                }
            }
            
            // Xử lý các đơn hàng đồng thời
            ExecutorService executor = Executors.newFixedThreadPool(n);
            List<Future<Boolean>> futures = executor.invokeAll(tasks);
            
            // Chờ tất cả task hoàn thành
            executor.shutdown();
            
            // In kết quả
            System.out.println("\n--- Kết quả ---");
            System.out.println("Tổng số đơn hàng: " + n);
            System.out.println("Số đơn hàng thành công: " + successCount.get());
            System.out.println("\nNhật ký:");
            for (String log : sharedLogs) {
                System.out.println(log);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
