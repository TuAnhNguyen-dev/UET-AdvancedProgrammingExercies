import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng robot
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Robot> robots = new ArrayList<>();

        // Quét dữ liệu đầu vào
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            int id = Integer.parseInt(input[1]);
            String modelName = input[2];

            switch (type) {
                case "DR":
                    robots.add(new DroneRobot(id, modelName));
                    break;
                case "FR":
                    robots.add(new FishRobot(id, modelName));
                    break;
                case "AR":
                    robots.add(new AmphibiousRobot(id, modelName));
                    break;
            }
        }

        // Duyệt danh sách, gọi task và kiểm tra kỹ năng bằng instanceof (Downcasting an toàn)
        for (int i = 0; i < robots.size(); i++) {
            Robot currentRobot = robots.get(i);

            // Hàm chung ai cũng có
            currentRobot.performMainTask();

            // Kiểm tra Interface để ép kiểu gọi hàm đặc thù
            if (currentRobot instanceof Flyable) {
                ((Flyable) currentRobot).fly();
            }
            if (currentRobot instanceof Swimmable) {
                ((Swimmable) currentRobot).swim();
            }
            if (currentRobot instanceof GPS) {
                ((GPS) currentRobot).getCoordinates();
            }

            // In dòng trống giữa các Robot (trừ Robot cuối cùng) để format giống Output
            if (i < robots.size() - 1) {
                System.out.println();
            }
        }

        sc.close();
    }
}