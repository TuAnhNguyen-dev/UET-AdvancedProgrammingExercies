package bai04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathTest {

    @Test
    void testHardcodedPath_WillFailOnLinuxAndMac() {
        // Cố tình code cứng dấu gạch ngược của Windows
        String folder = "logs";
        String filename = "audit.log";
        String expectedPath = "logs\\audit.log"; // Kiểu Windows

        // Mô phỏng hàm nối chuỗi đường dẫn (lỗi thiết kế)
        String actualPath = folder + "\\" + filename;

        assertEquals(expectedPath, actualPath, "Đường dẫn không khớp!");
        System.out.println("Path tạo ra: " + actualPath);
    }
}