import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    protected static List<Device> deviceList = new ArrayList<>();

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;

        deviceList.add(this);
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(name + " turned off");
    }

    public String getName() {
        return name;
    }
}
