public class Main {
    public static void main(String[] args) {
        MotoBike motoBike = new MotoBike("29A-12345", "Honda", 10.5);
        System.out.println(motoBike.getInfor());

        System.out.println("Current fuel level: " + motoBike.fuelLevel + " liters");
        motoBike.refuel(5);
        System.out.println("Fuel level after refueling: " + motoBike.fuelLevel + " liters");

        System.out.println();

        Car car = new Car("30B-54321", "Toyota", 20.0);
        System.out.println(car.getInfor());

        System.out.println();

        ElectricCar electricCar = new ElectricCar("31C-67890", "Tesla", 80);
        System.out.println(electricCar.getInfor());

        System.out.println("Current battery level: " + electricCar.batteryPercent + " kWh");
        electricCar.charge(20);
        System.out.println("Battery level after charging: " + electricCar.batteryPercent + " kWh");
    }
}
