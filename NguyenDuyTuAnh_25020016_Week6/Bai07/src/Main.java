public class Main {
    public static void main(String[] args) {
        NotifierDecorator person1 = new SMSNotifier(
                new EmailNotifier()
        );
        NotifierDecorator person2 = new SMSNotifier(
                new FacebookNotifier(
                        new EmailNotifier()
                )
        );

        person1.send("This is for person 1");
        person2.send("This is for person 2");
    }
}
