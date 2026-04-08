public class Main {
    public static void main(String[] args) {
        Person p = new Person("Person p");
        p.setMe(p);
        p = null;
        Person me = p.getMe();
        System.out.println(me.getName());
    }
}
