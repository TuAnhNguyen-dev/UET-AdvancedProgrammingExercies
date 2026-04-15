public class Main {
    public static void main(String[] args) {
        Task taskA = new Task("Task A", 2000);
        Task taskB = new Task("Task B", 3000);

        Thread thread1 = new Thread(taskA);
        Thread thread2 = new Thread(taskB);

        // start sẽ chạy đồng thời, run sẽ chạy tuần tự
        thread1.start();
        thread2.start();

        try {
            // join sẽ chờ cho thread kết thúc rồi mới chạy tiếp, nếu không có join thì sẽ chạy song song
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll tasks done.");
    }
}
