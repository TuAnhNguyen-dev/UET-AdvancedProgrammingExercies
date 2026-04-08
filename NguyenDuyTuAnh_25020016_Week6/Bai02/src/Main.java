public class Main {
    public static void main(String[] args) {
        // Kịch bản 1: Hệ thống muốn gửi OTP qua SMS
        NotificationApp smsApp = new SmsApp();
        smsApp.notifyUser("Mã OTP của bạn là 123456. Vui lòng không chia sẻ cho ai.");

        // Kịch bản 2: Hệ thống muốn gửi hóa đơn qua Email
        NotificationApp emailApp = new EmailApp();
        emailApp.notifyUser("Cảm ơn bạn đã mua hàng. Hóa đơn #9999 đính kèm.");
    }
}