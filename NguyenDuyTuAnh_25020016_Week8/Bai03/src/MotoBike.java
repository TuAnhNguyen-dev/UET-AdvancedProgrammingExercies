public class MotoBike extends ICEVehicle{
    public MotoBike(String plate, String brand, double fuelLevel) {
        super(plate, brand, fuelLevel);
    }

    @Override
    protected String getVehicleType() {
        return "MotoBike";
    }
}
