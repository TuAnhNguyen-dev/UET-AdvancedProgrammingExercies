import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteBinary {
    public void writeData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên tệp để ghi (vd: numbers.dat): ");
        String fileName = sc.nextLine();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Bạn muốn ghi bao nhiêu số nguyên? ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int num = Integer.parseInt(sc.nextLine());
                dos.writeInt(num);
            }
            System.out.println("Ghi dữ liệu thành công vào " + fileName);

        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi khi nhập số dòng");
        }
    }
}
