public class SmartSpeaker extends Device implements WifiConnectable {
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}