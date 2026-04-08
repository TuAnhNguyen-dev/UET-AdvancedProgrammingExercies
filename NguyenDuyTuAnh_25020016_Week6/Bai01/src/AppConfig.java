public class AppConfig {
    private static volatile AppConfig instance;

    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
        try {
            System.out.println(Thread.currentThread().getName() + " đang khởi tạo cấu hình...");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.appName = "Auction System";
        this.version = "1.0.0";
        this.logLevel = "DEBUG";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                } else {
                    System.out.println(Thread.currentThread().getName() + " thấy instance đã được tạo bởi luồng khác, bỏ qua!");
                }
            }
        }

        return instance;
    }

    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public String getLogLevel() { return logLevel; }
}