import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    private LocalDate expiryDate;
    private double discount = 0.2;

    public Food(String name, double basePrice, LocalDate expiryDate) {
        super(name, basePrice);
        this.expiryDate = expiryDate;
    }

    @Override
    public double getFinalPrice() {
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(today, expiryDate);
        double price = getBasePrice();

        if (days < 7) {
            price *= (1-discount);
        }

        return price;
    }

    @Override
    public String getType() {
        return "Food";
    }
}
