public class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier other) {
        super(other);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println(msg + ", sent by Facebook");
    }
}
