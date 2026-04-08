class Config {
    private String theme;

    public Config(String theme) {
        this.theme = theme;
    }

    public Config(Config other) {
        this.theme = other.theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Config clone() {
        return new Config(this);
    }
}

public class Prototype {
    public static void test() {
        System.out.println("--- KIỂM TRA PROTOTYPE   ---");

        Config config1 = new Config("Blue");
        Config config2 = config1.clone();

        config2.setTheme("Red");

        System.out.println(config1.getTheme());
        System.out.println(config2.getTheme());
    }
}
