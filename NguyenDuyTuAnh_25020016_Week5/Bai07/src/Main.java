import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = sc.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String destPath = sc.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            File sourceFile = new File(sourcePath);

            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file not found");
            }

            reader = new BufferedReader(new FileReader(sourceFile));
            writer = new PrintWriter(new FileWriter(destPath));
            String line;

            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;

                // Giả lập lỗi tại dòng thứ 5
                if (lineCount == 5) {
                    throw new IOException("Giả lập lỗi ghi đĩa giữa chừng!");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            sc.close();
        }
    }
}

/*
1. reader not found
2. writer exist
3. writer is read-only
 */