public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Tuổi", 20);

        Pair<String, String> p2 = new Pair<>("Mã SV", "SV001");

        Pair<Integer, Double> p3 = new Pair<>(105, 21.5);

        Pair<Double, Boolean> p4 = new Pair<>(4.0, true);

//        Pair<String, Integer> pError = new Pair<>("Tuổi", "Hai mươi");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}