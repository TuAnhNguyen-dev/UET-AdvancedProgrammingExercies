import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @BeforeAll
    static void initAll() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("=== Kết thúc ===");
    }

    @Nested
    @DisplayName("Kiểm thử hàm max(a, b)")
    class MaxTests {
        @Test
        @DisplayName("TC_MAX_01: a > b")
        void testMaxAGreaterThanB() {
            assertEquals(15, MathUtils.max(15, 10));
        }

        @Test
        @DisplayName("TC_MAX_02: a < b")
        void testMaxALessThanB() {
            assertEquals(20, MathUtils.max(5, 20));
        }

        @Test
        @DisplayName("TC_MAX_03: a = b")
        void testMaxAEqualsB() {
            assertEquals(7, MathUtils.max(7, 7));
        }

        @Test
        @DisplayName("TC_MAX_04 & 05: Kiểm tra giá trị biên (BVA)")
        void testMaxBoundaries() {
            assertAll(
                    () -> assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0)),
                    () -> assertEquals(0, MathUtils.max(0, Integer.MIN_VALUE))
            );
        }
    }

    @Nested
    @DisplayName("Kiểm thử hàm divide(a, b)")
    class DivideTests {
        @Test
        @DisplayName("TC_DIV_01: b là số dương")
        void testDivideByPositive() {
            assertEquals(5, MathUtils.divide(10, 2));
        }

        @Test
        @DisplayName("TC_DIV_02: b là số âm")
        void testDivideByNegative() {
            assertEquals(-4, MathUtils.divide(12, -3));
        }

        @Test
        @DisplayName("TC_DIV_03: b bằng 0 (Ngoại lệ)")
        void testDivideByZero() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                MathUtils.divide(5, 0);
            });
            assertEquals("Divider must not be zero", exception.getMessage());
        }
    }
}