public abstract class ICEVehicle extends Vehicle{
    protected double fuelLevel;

    public ICEVehicle(String plate, String brand, double fuelLevel) {
        super(plate, brand);
        this.fuelLevel = fuelLevel;
    }

    public void refuel(double liters) {
        fuelLevel += liters;
    }
}
