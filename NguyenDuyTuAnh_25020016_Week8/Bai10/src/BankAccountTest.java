import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    // Chạy TRƯỚC MỖI @Test để đảm bảo tính cô lập
    // Bất kể test trước đó làm gì, cứ vào test mới là tài khoản lại có 500
    @BeforeEach
    void setUp() {
        account = new BankAccount("123456789", "Tuan Anh", 500.0);
    }

    @Nested
    @DisplayName("Kiểm thử hàm nạp tiền - deposit()")
    class DepositTests {

        @Test
        @DisplayName("TC_DEP_01 & 04: Nạp tiền hợp lệ (EP & BVA)")
        void testValidDeposit() {
            account.deposit(100.0);
            assertEquals(600.0, account.getBalance(), 0.001);

            account.deposit(0.01); // BVA sát biên
            assertEquals(600.01, account.getBalance(), 0.001);
        }

        @Test
        @DisplayName("TC_DEP_02 & 03: Nạp tiền <= 0 ném lỗi (BVA)")
        void testInvalidDeposit() {
            assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
            assertThrows(IllegalArgumentException.class, () -> account.deposit(-0.01));
        }
    }

    @Nested
    @DisplayName("Kiểm thử hàm rút tiền - withdraw()")
    class WithdrawTests {

        @Test
        @DisplayName("TC_WIT_01 & 03 & 04: Rút tiền hợp lệ, đủ số dư (EP & BVA)")
        void testValidWithdraw() {
            assertTrue(account.withdraw(200.0));
            assertEquals(300.0, account.getBalance(), 0.001);

            // Rút sạch sành sanh
            assertTrue(account.withdraw(300.0));
            assertEquals(0.0, account.getBalance(), 0.001);
        }

        @Test
        @DisplayName("TC_WIT_05 & 06: Rút tiền vượt quá số dư (EP & BVA)")
        void testOverdraw() {
            // Rút lố 1 đồng (BVA)
            assertFalse(account.withdraw(500.01));
            // Kiểm tra số dư phải được bảo toàn
            assertEquals(500.0, account.getBalance(), 0.001);
        }

        @Test
        @DisplayName("TC_WIT_02: Rút tiền <= 0 ném lỗi")
        void testInvalidWithdraw() {
            assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        }
    }

    @Test
    @DisplayName("Kiểm tra tính nhất quán theo trình tự nghiệp vụ (Integration/Flow Test)")
    void testAccountConsistencySequence() {
        // 1. Số dư ban đầu là 0
        BankAccount sequenceAccount = new BankAccount("999", "Tuan Anh Sequence", 0.0);
        assertEquals(0.0, sequenceAccount.getBalance(), 0.001);

        // 2. Nạp 500
        sequenceAccount.deposit(500.0);
        assertEquals(500.0, sequenceAccount.getBalance(), 0.001);

        // 3. Rút 200 (thành công)
        assertTrue(sequenceAccount.withdraw(200.0));
        assertEquals(300.0, sequenceAccount.getBalance(), 0.001);

        // 4. Rút 400 (thất bại)
        assertFalse(sequenceAccount.withdraw(400.0));

        // 5. Kiểm tra số dư cuối phải đúng bằng 300
        assertEquals(300.0, sequenceAccount.getBalance(), 0.001);
    }
}