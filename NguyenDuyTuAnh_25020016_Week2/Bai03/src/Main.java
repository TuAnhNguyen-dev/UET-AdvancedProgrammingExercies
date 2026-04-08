public class Main {
    public static void main(String[] args) {
        NumberWapper n1 = new NumberWapper(3);
        NumberWapper n2 = new NumberWapper(29);

        System.out.println("before swap");
        System.out.println("n1 " + n1.getNumber());
        System.out.println("n2 " + n2.getNumber());

        NumberWapper.swap(n1, n2);

        System.out.println("after swap");
        System.out.println("n1 " + n1.getNumber());
        System.out.println("n2 " + n2.getNumber());
    }
}
