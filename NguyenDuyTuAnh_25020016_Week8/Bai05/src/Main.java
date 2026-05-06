abstract class Order {

    private double weight;
    private double distance;

    public Order(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    // Each subclass defines its own rates and bonus
    protected abstract double getWeightRate();
    protected abstract double getDistanceRate();
    protected abstract double getBonus();


    public double getDeliveryFee() {
        return getWeight() * getWeightRate() + getDistance() * getDistanceRate() + getBonus();
    }

    public abstract String getLabel();
}

class StandardOrder extends Order {
    protected static final double WEIGHT_RATE = 3000;
    protected static final double DISTANCE_RATE = 500;
    private static final double BONUS = 0;

    public StandardOrder(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    protected double getWeightRate() {
        return WEIGHT_RATE;
    }

    @Override
    protected double getDistanceRate() {
        return DISTANCE_RATE;
    }

    @Override
    protected double getBonus() {
        return BONUS;
    }

    @Override
    public String getLabel() {
        return "Thường";
    }
}

class ExpressOrder extends StandardOrder {
    public ExpressOrder(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    protected double getWeightRate() {
        return WEIGHT_RATE * 1.5;  // Automatic dependency on StandardOrder's rate
    }

    @Override
    protected double getDistanceRate() {
        return DISTANCE_RATE * 1.5;
    }

    @Override
    public String getLabel() {
        return "Hỏa tốc";
    }
}

class FragileOrder extends Order {
    private static final double WEIGHT_RATE = 5000;
    private static final double DISTANCE_RATE = 700;
    private static final double BONUS = 20000;  // Phí bảo hiểm/xử lý hàng dễ vỡ

    public FragileOrder(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    protected double getWeightRate() {
        return WEIGHT_RATE;
    }

    @Override
    protected double getDistanceRate() {
        return DISTANCE_RATE;
    }

    @Override
    protected double getBonus() {
        return BONUS;
    }

    @Override
    public String getLabel() {
        return "Hàng dễ vỡ";
    }
}

class BulkyOrder extends Order {
    private static final double WEIGHT_RATE = 4000;
    private static final double DISTANCE_RATE = 600;
    private static final double BONUS = 50000;  // Phí xử lý hàng cồng kềnh

    public BulkyOrder(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    protected double getWeightRate() {
        return WEIGHT_RATE;
    }

    @Override
    protected double getDistanceRate() {
        return DISTANCE_RATE;
    }

    @Override
    protected double getBonus() {
        return BONUS;
    }

    @Override
    public String getLabel() {
        return "Hàng cồng kềnh";
    }
}

public class Main {
    public static void main(String[] args) {
        Order standardOrder = new StandardOrder(2, 10);
        Order expressOrder = new ExpressOrder(2, 10);
        Order fragileOrder = new FragileOrder(2, 10);
        Order bulkyOrder = new BulkyOrder(2, 10);

        System.out.println(standardOrder.getLabel() + " - Phí giao hàng: " + standardOrder.getDeliveryFee());
        System.out.println(expressOrder.getLabel() + " - Phí giao hàng: " + expressOrder.getDeliveryFee());
        System.out.println(fragileOrder.getLabel() + " - Phí giao hàng: " + fragileOrder.getDeliveryFee());
        System.out.println(bulkyOrder.getLabel() + " - Phí giao hàng: " + bulkyOrder.getDeliveryFee());
    }
}
