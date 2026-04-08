class Logger {
    private static volatile Logger instance;

//    chặn new
    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }

        return instance;
    }
}

public class Singleton {
    public static void test() {
        System.out.println("--- KIỂM TRA SINGLETON ---");

        Thread thread1 = new Thread(() -> {
            Logger config1 = Logger.getInstance();
            System.out.println("Thread1 nhận được config với HashCode: " + config1.hashCode() + '\n');
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            Logger config2 = Logger.getInstance();
            System.out.println("Thread2 nhận được config với HashCode: " + config2.hashCode() + '\n');
        }, "Thread2");

        thread1.start();
        thread2.start();
    }
}