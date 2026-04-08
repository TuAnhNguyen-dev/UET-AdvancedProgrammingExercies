public class Electronics extends Product{
    private double warrantyFee;
    private double VAT = 0.1;

    public Electronics(String name, double basePrice, double warrantyFee) {
        super(name, basePrice);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        double price = getBasePrice();
        return price + price * VAT + warrantyFee;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}
