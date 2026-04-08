public class Main {
    public static void main(String[] args) {
        WriteData writer = new WriteData();
        ReadData reader = new ReadData();

        System.out.println("Phần 1. Ghi dữ liệu");
        writer.writeData();

        System.out.println("\nPhần 2. Đọc dữ liệu");
        reader.readData();
    }
}
