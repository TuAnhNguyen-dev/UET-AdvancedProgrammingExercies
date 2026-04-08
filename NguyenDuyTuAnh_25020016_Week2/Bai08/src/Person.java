public class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }

    public void setMe(Person me) {
        this.me = me;
    }

    public String getName() {
        return this.name;
    }

    public Person getMe() {
        return me;
    }
}
