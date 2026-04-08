public class Main {
    public static void main(String[] args) {
        WriteBinary writer = new WriteBinary();
        ReadBinary reader = new ReadBinary();

        writer.writeData();
        reader.readData();
    }
}
