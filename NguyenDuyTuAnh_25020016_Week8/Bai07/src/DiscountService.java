public class DiscountService {

    public double calculateDiscount(double price, String memberType) {
        // 1. Kiểm tra giá trị biên dưới của price
        if (price < 0) {
            throw new IllegalArgumentException("Giá (price) không được nhỏ hơn 0.");
        }

        // 2. Xử lý logic theo từng hạng thành viên
        if (memberType == null) {
            throw new IllegalArgumentException("Loại thành viên (memberType) không hợp lệ.");
        }

        switch (memberType.toUpperCase()) {
            case "GUEST":
                return 0.0; // 0%

            case "MEMBER":
                if (price < 100) return 0.05; // 5%
                return 0.10;                  // 10%

            case "VIP":
                if (price < 100) return 0.15; // 15%
                return 0.20;                  // 20%

            default:
                // Nếu nhập "OTHER", "UNKNOWN"... sẽ rơi vào đây
                throw new IllegalArgumentException("Loại thành viên không hợp lệ: " + memberType);
        }
    }
}