public class Car extends ICEVehicle{
    public Car(String plate, String brand, double fuelLevel) {
        super(plate, brand, fuelLevel);
    }

    @Override
    protected String getVehicleType() {
        return "Car";
    }
}
