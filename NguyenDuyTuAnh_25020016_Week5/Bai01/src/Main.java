public class Main {
    public void useString() {
        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += 'a';
        }
    }

    public void useStringBuffer() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 100_000; i++) {
            s.append('a');
        }
    }

    public String contentAnalysis(String text) {
        int count = text.split("[.!?]+").length;

        System.out.println(String.format("This text has %d sentences.", count));

        text = text.replace("Java", "Python");

        return text;
    }

    public static void main(String[] args) {
        Main obj = new Main();

        long start, end1, end2;

        start = System.currentTimeMillis();
        obj.useString();
        end1 = System.currentTimeMillis();
        obj.useStringBuffer();
        end2 = System.currentTimeMillis();

        System.out.println(String.format("String: %dms - StringBuffer: %dms", end1 - start, end2 - end1));

        String text = "Hello... Java!";
        String newText = obj.contentAnalysis(text);

        System.out.println(newText);
    }
}
