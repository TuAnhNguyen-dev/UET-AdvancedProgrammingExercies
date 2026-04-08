import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("test.inp"));

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            switch (type) {
                case "L":
                    new SmartLight(id, name);
                    break;
                case "AC":
                    new AirConditioner(id, name);
                    break;
                case "S":
                    new SmartSpeaker(id, name);
                    break;
                case "C":
                    new Curtain(id, name);
                    break;
            }
        }

        System.out.println("Turn Off All Devices:");
        for (Device device : Device.deviceList) {
            device.turnOff();
        }

        System.out.println("\nSetup Wifi:");
        for (Device device : Device.deviceList) {
            if (device instanceof WifiConnectable) {
                ((WifiConnectable) device).connectWifi();
            }
        }

        sc.close();
    }
}