public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier other) {
        super(other);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println(msg + ", sent by SMS");
    }
}
