import java.io.*;

public class ReadData {
    public void readData() {
        String fileName = "students.dat";

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("Danh sách sinh viên trong tệp:");

            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s.toString());
            }

        } catch (EOFException e) {
            System.out.println("\n--- Đã đọc hết danh sách sinh viên ---");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp " + fileName);
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi không tìm thấy class: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi đọc tệp: " + e.getMessage());
        }
    }
}
