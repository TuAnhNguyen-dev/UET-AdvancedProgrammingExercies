public class ElectricCar extends EVehicle{
    public ElectricCar(String plate, String brand, int batteryPercent) {
        super(plate, brand, batteryPercent);
    }

    @Override
    protected String getVehicleType() {
        return "ElectricCar";
    }
}
