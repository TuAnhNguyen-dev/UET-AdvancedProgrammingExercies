import javax.xml.crypto.Data;

interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    // Cố tình KHÔNG ghi public
    public void show() {
        System.out.println("Show Data");
    }
}


public class Main {
    public static void main(String[] args) {
        String error = "show() in DataManager cannot implement show() in IData\n" +
                "    void show() {\n" +
                "         ^\n" +
                "  attempting to assign weaker access privileges; was public";

        System.out.println(error);

        DataManager dataManager = new DataManager();
        dataManager.show();
    }
}
