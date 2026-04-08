public class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[EMAIL] Đang kết nối tới SMTP Server...");
        System.out.println(" -> Đã gửi Email với nội dung: " + msg);
    }
}