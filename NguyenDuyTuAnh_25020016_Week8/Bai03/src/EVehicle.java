public abstract class EVehicle extends Vehicle{
    protected int batteryPercent;

    public EVehicle(String plate, String brand, int batteryPercent) {
        super(plate, brand);
        this.batteryPercent = batteryPercent;
    }

    public void charge(int percent) {
        batteryPercent += percent;
    }
}
