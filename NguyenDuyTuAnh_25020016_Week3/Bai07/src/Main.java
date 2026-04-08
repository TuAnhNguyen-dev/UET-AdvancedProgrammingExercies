import java.util.Scanner;

abstract class Room {
    protected int nights;
    protected double pricePerNight;

    public Room(int nights, double pricePerNight) {
        this.nights = nights;
        this.pricePerNight = pricePerNight;
    }

    public abstract double calculateCost();
}

class StandardRoom extends Room {

    public StandardRoom(int nights) {
        super(nights, 500_000);
    }

    @Override
    public double calculateCost() {
        double total = nights * pricePerNight;
        if (nights > 3) {
            total *= 0.95;
        }
        return total;
    }
}

class VipRoom extends Room {

    public VipRoom(int nights) {
        super(nights, 2_000_000);
    }

    @Override
    public double calculateCost() {
        return nights * pricePerNight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next();
        int nights = sc.nextInt();

        Room room;

        if (type.equals("S")) {
            room = new StandardRoom(nights);
        } else {
            room = new VipRoom(nights);
        }

        System.out.println((long) room.calculateCost());
    }
}