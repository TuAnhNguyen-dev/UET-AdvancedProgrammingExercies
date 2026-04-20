import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountServiceTest {

    private final DiscountService service = new DiscountService();

    // =========================================================
    // TEST CASE 1: KIỂM THỬ CÁC TRƯỜNG HỢP HỢP LỆ (HAPPY PATH)
    // Áp dụng: Equivalence Partitioning (EP) & Pairwise
    // =========================================================
    @ParameterizedTest(name = "Price: {0}, Member: {1} => Expected Discount: {2}")
    @CsvSource({
            // price, memberType, expectedDiscount
            "50.0,    GUEST,      0.0",   // PW_05: price < 100, GUEST
            "50.0,    MEMBER,     0.05",  // PW_06: price < 100, MEMBER
            "50.0,    VIP,        0.15",  // PW_07: price < 100, VIP

            "150.0,   GUEST,      0.0",   // PW_09: price >= 100, GUEST
            "150.0,   MEMBER,     0.10",  // PW_10: price >= 100, MEMBER
            "150.0,   VIP,        0.20",  // PW_11: price >= 100, VIP

            // THÊM GIÁ TRỊ BIÊN (BVA) TẠI MỐC 100
            "99.99,   MEMBER,     0.05",  // Dưới biên 100 (vẫn tính mức < 100)
            "100.0,   MEMBER,     0.10",  // Ngay tại biên 100 (tính mức >= 100)
            "100.01,  MEMBER,     0.10"   // Trên biên 100 (tính mức >= 100)
    })
    @DisplayName("Kiểm tra chiết khấu với dữ liệu hợp lệ")
    void testValidDiscounts(double price, String memberType, double expected) {
        double actualDiscount = service.calculateDiscount(price, memberType);
        // So sánh số thực (double) luôn cần tham số delta (sai số cho phép)
        assertEquals(expected, actualDiscount, 0.0001);
    }

    // =========================================================
    // TEST CASE 2: KIỂM THỬ NGOẠI LỆ DO GIÁ ÂM (PRICE < 0)
    // =========================================================
    @ParameterizedTest(name = "Negative Price: {0}, Member: {1} => Ném Exception")
    @CsvSource({
            "-10.0, GUEST",  // PW_01
            "-10.0, MEMBER", // PW_02
            "-10.0, VIP",    // PW_03
            "-0.01, MEMBER"  // BVA: Ngay dưới biên 0
    })
    @DisplayName("Ném lỗi khi giá trị đơn hàng < 0")
    void testNegativePriceThrowsException(double price, String memberType) {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateDiscount(price, memberType);
        });
    }

    // =========================================================
    // TEST CASE 3: KIỂM THỬ NGOẠI LỆ DO SAI LOẠI THÀNH VIÊN
    // =========================================================
    @Test
    @DisplayName("Ném lỗi khi loại thành viên không tồn tại (UNKNOWN)")
    void testInvalidMemberTypeThrowsException() {
        // PW_08 và PW_12: Loại thành viên linh tinh
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateDiscount(50.0, "UNKNOWN_MEMBER");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateDiscount(150.0, "SUPER_VIP");
        });
    }
}