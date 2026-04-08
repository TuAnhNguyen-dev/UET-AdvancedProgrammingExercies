import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên a: ");
            int a = sc.nextInt();

            System.out.print("Nhập số nguyên b: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("Kết quả phép chia: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập vào một số nguyên!");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể thực hiện phép chia cho 0!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi không xác định: " + e.getMessage());
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
