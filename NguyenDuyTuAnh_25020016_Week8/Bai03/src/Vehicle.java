public abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    public String getInfor() {
        return String.format("%s [%s] - %s", getVehicleType(), plate, brand);
    }

    protected abstract String getVehicleType();
}
