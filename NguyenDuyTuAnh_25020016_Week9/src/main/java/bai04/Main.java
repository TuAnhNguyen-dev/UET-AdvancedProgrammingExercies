package bai04;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {

  @Test
  void testCrossPlatformPath_WillPassEverywhere() {
    // Sử dụng Paths.get() để Java tự tính toán dấu gạch chéo /, \
    Path p = Paths.get("logs", "audit.log");

    // Kiểm tra xem hệ điều hành có nhận diện đúng thư mục cha không
    assertEquals("logs", p.getParent().toString());
    assertEquals("audit.log", p.getFileName().toString());

    System.out.println("Đường dẫn chuẩn trên OS hiện tại: " + p.toString());
  }

  // Hoặc nếu muốn dùng API cũ (File.separator)
  @Test
  void testCrossPlatformWithFileSeparator() {
    String folder = "logs";
    String filename = "audit.log";

    // File.separator tự động là "\" trên Windows và "/" trên Linux
    String safePath = folder + java.io.File.separator + filename;

    assertTrue(safePath.endsWith("audit.log"));
  }
}