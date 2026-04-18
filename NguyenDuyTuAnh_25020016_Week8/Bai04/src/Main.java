import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }
    public String getPlate() { return plate; }

    abstract public double getFee(int hours);

    public int getBonusPoints(int hours) {
        return 1;
    }
}

class Car extends Vehicle {
    public Car(String plate) {
        super(plate);
    }

    @Override
    public double getFee(int hours) {
        double fee = 10;
        if (hours > 2) {
            fee += (hours - 2) * 3;
        }
        return fee;
    }
}

class Bike extends Vehicle {
    public Bike(String plate) {
        super(plate);
    }

    @Override
    public double getFee(int hours) {
        double fee = 5;
        if (hours > 3) {
            fee += (hours - 3) * 2;
        }
        return fee;
    }
}

class Truck extends Vehicle {
    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double getFee(int hours) {
        return 15 + hours * 4;
    }

    @Override
    public int getBonusPoints(int hours) {
        return (hours > 5) ? 2 : 1;
    }
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }
    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }

    public double getFee() {
        return vehicle.getFee(hours);
    }

    public int getBonusPoints() {
        return vehicle.getBonusPoints(hours);
    }
}

class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }
    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public double getAllFee() {
        double totalFee = 0;
        for (ParkingTicket each : tickets) {
            totalFee += each.getFee();
        }

        return totalFee;
    }

    public int getBonusPoints() {
        int bonusPoints = 0;
        for (ParkingTicket each : tickets) {
            bonusPoints += each.getBonusPoints();
        }
        return bonusPoints;
    }

    public String receipt() {
        StringBuilder result = new StringBuilder("Parking Receipt for " + name + "\n");

        for (ParkingTicket each : tickets) {
            result.append("\t").append(each.getVehicle().getPlate()).append("\t").append(each.getFee()).append("\n");
        }

        result.append("Total fee is ").append(getAllFee()).append("\n");
        result.append("You earned ").append(getBonusPoints()).append(" bonus points");
        return result.toString();
    }
}



public class Main {
    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("John Doe");

        Car car1 = new Car("29A-12345");
        Bike bike1 = new Bike("30B-54321");
        Truck truck1 = new Truck("31C-67890");

        customer.addTicket(new ParkingTicket(car1, 4));
        customer.addTicket(new ParkingTicket(bike1, 5));
        customer.addTicket(new ParkingTicket(truck1, 6));

        System.out.println(customer.receipt());
    }
}
