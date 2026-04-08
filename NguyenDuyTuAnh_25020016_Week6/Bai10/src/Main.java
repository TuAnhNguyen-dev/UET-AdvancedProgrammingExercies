public class Main {
    public static void main(String[] args) {
        // Giả sử lấy Logger ở class A
        Logger logger1 = Logger.getInstance();

        // Giả sử lấy Logger ở class B
        Logger logger2 = Logger.getInstance();

        // Kiểm tra xem hai biến có đang trỏ chung vào một vùng nhớ (địa chỉ) hay không
        System.out.println("Logger instances equal: " + (logger1 == logger2));

        // Tiến hành ghi log từ các biến khác nhau để thấy chúng hoạt động như một
        logger1.logInfo("Application started");
        logger2.logInfo("Processing data...");
        logger1.logError("Something went wrong");
    }
}