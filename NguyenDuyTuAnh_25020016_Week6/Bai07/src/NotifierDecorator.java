public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapper;

    public NotifierDecorator(Notifier otherNotifier) {
        this.wrapper = otherNotifier;
    }

    @Override
    public void send(String msg) {
        wrapper.send(msg);
    }
}
