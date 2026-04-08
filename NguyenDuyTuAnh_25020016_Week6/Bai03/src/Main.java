import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập hệ điều hành muốn giả lập (win / mac): ");
        String osConfig = sc.nextLine().trim().toLowerCase();

        // BƯỚC 1: Lựa chọn Nhà máy tại thời điểm chạy (Runtime)
        UIFactory factory = switch (osConfig) {
            case "win"   -> new WindowsFactory();
            case "mac"   -> new MacFactory();
            default      -> throw new IllegalArgumentException("Lỗi: Hệ điều hành không được hỗ trợ!");
        };

        System.out.println("\n--- Bắt đầu dựng giao diện ---");

        // BƯỚC 2: Từ nhà máy đã chọn, tạo ra bộ sản phẩm.
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // BƯỚC 3: Hiển thị
        button.render();
        checkbox.render();

        sc.close();
    }
}