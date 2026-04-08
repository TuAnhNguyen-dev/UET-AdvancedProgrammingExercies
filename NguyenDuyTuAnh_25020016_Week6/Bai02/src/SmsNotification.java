public class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[SMS] Đang kết nối tới Telecom Provider...");
        System.out.println(" -> Đã gửi tin nhắn SMS với nội dung: " + msg);
    }
}