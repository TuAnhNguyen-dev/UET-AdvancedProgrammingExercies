public class Main {
    public static void main(String[] args) {
        // Cách 1: Dùng constructor không tham số
        Student s1 = new Student();
        s1.setGpa(3.5);
        System.out.print("Sinh viên 1: "); s1.displayInfor();

        // Cách 2: Dùng constructor (id, name)
        Student s2 = new Student("SV002", "Nguyen Van B");
        s2.setEmail("b@gmail.com");
        s2.setGpa(3.8);
        System.out.print("Sinh viên 2: "); s2.displayInfor();

        // Cách 3: Dùng Copy Constructor (tạo s3 giống hệt s2)
        Student s3 = new Student(s2);
        System.out.print("Sinh viên 3 (Copy từ s2): "); s3.displayInfor();

        // Thử nghiệm gán GPA < 0
        System.out.println("\n--- Thử nghiệm lỗi GPA ---");
        s1.setGpa(-1.0);
        s1.displayInfor(); // GPA của s1 vẫn sẽ là 3.5 (giữ nguyên giá trị cũ)
    }
}