class TranscriptRecord {
    private Student student;
    private Course course;

    private double midtermScore;
    private double finalScore;
    private double assignmentScore;

    public TranscriptRecord(Student student, Course course,
                            double midtermScore, double finalScore, double assignmentScore) {
        this.student = student;
        this.course = course;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.assignmentScore = assignmentScore;
    }

    public double calculateFinalGrade() {
        return assignmentScore * 0.2 + midtermScore * 0.3 + finalScore * 0.5;
    }

    public String getAcademicStatus() {
        double grade = calculateFinalGrade();
        if (grade >= 8.5) return "Giỏi";
        if (grade >= 7.0) return "Khá";
        if (grade >= 5.5) return "Trung bình";
        return "Yếu";
    }

    public String getScoreDetail() {
        return String.format("Điểm GK: %.1f | Điểm CK: %.1f | Điểm BT: %.1f",
                midtermScore, finalScore, assignmentScore);
    }

    public String getFinalScore() {
        return String.format("Điểm tổng kết: %.1f - Học lực: %s%n", calculateFinalGrade(), getAcademicStatus());
    }

    public void printTranscript() {
        System.out.println(student.getDetail());
        System.out.println(course.getDetail());
        System.out.println(getScoreDetail());
        System.out.printf(getFinalScore());
    }
}

class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Student extends Person {
    private double gpa;

    public Student(String id, String name, double gpa) {
        super(id, name);
        this.gpa = gpa;
    }

    public String getDetail() {
        return String.format("Sinh viên: " + getName() + " (ID: " + getId() + ")");
    }
}

class TeachingAssistant extends Person {
    public TeachingAssistant(String id, String name) {
        super(id, name);
    }
}

class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course (String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getDetail() {
        return String.format("Môn học: " + courseName + " (" + courseId + ") - " + credits + " tín chỉ");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("SV001", "Nguyen Van A", 3.5);
        Course course = new Course("CS101", "Lập trình Java", 3);
        TranscriptRecord manager = new TranscriptRecord(student, course, 8.0, 9.0, 7.5);
        manager.printTranscript();
    }
}
