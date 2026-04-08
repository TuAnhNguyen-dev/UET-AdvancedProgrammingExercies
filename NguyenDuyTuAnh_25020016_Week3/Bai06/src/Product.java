public abstract class Product {
    private int id;
    private String name;
    private double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {return this.name;}

    public double getFinalPrice() {return this.basePrice;}

    public double getBasePrice() {return this.basePrice;}

    public String getType() {return "N/A";};

    @Override
    public String toString() {
        return String.format("%s - %s - %.1f", name, getType(), getFinalPrice());
    }
}
