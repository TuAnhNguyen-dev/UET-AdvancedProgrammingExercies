public class Main {
    public static void main(String[] args) {
        System.out.println("--- BẮT ĐẦU KIỂM TRA SINGLETON ĐA LUỒNG ---\n");

        // Tạo luồng 1
        Thread threadA = new Thread(() -> {
            AppConfig configA = AppConfig.getInstance();
            System.out.println("Thread A nhận được config với HashCode: " + configA.hashCode());
        }, "Thread A");

        // Tạo luồng 2
        Thread threadB = new Thread(() -> {
            AppConfig configB = AppConfig.getInstance();
            System.out.println("Thread B nhận được config với HashCode: " + configB.hashCode());
        }, "Thread B");

        // Khởi chạy 2 luồng gần như cùng một lúc
        threadA.start();
        threadB.start();
    }
}