import java.io.*;
import java.util.Scanner;

public class ReadBinary {
    public void readData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp để đọc: ");
        String fileName = sc.nextLine();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Nội dung tệp " + fileName + ":");

            while (true) {
                int num = dis.readInt();
                System.out.print(num + " ");
            }

        } catch (EOFException e) {
            System.out.println("\n--- Đã đọc hết tệp (EOF reached) ---");
        } catch (FileNotFoundException e) {
            System.err.println("Tệp không tồn tại!");
        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
