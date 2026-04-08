import java.io.*;
import java.util.Scanner;

public class WriteData {
    public void writeData() {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            while (true) {
                System.out.print("Nhập ID (hoặc gõ 'END' để kết thúc): ");
                String id = sc.nextLine().trim();

                if (id.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.print("Nhập tên sinh viên: ");
                String name = sc.nextLine().trim();

                double gpa;
                while (true) {
                    System.out.print("Nhập GPA: ");

                    try {
                        gpa = Double.parseDouble(sc.nextLine().trim());

                        if (gpa < 0 || gpa > 10) {
                            System.out.println("Lỗi: Điểm GPA phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                            continue;
                        }

                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Điểm GPA phải là một số thực (ví dụ: 3.5). Vui lòng nhập lại!");
                    }
                }

                Student student = new Student(id, name, gpa);
                oos.writeObject(student);
                System.out.println(" -> Đã lưu sinh viên: " + name + "\n");
            }
            System.out.println("Đã ghi toàn bộ danh sách ra tệp: " + fileName);

        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Điểm GPA phải là một số thực!");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi khi đọc tệp: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi ghi tệp: " + e.getMessage());
        }
    }
}
