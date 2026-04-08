public abstract class NotificationApp {
    protected abstract Notification createNotification();

    public void notifyUser(String msg) {
        System.out.println("\n--- Chuẩn bị gửi thông báo ---");
        Notification notification = createNotification();

        notification.send(msg);
    }
}
