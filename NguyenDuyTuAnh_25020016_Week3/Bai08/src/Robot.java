public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel = 0;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }

    final public void showIdentidy() {
        System.out.println("ID: " + id + " - Model: " + modelName);
    }

    public abstract void performMainTask();

    public String getModelName() {
        return this.modelName;
    }
}
