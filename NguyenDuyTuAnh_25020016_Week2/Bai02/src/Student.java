class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {}

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Student otherStudent) {
        this.id = otherStudent.id;
        this.name = otherStudent.name;
        this.email = otherStudent.email;
        this.gpa = otherStudent.gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4) {
            System.out.println("Invalid gpa");
        } else {
            this.gpa = gpa;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayInfor() {
        String s = String.format("Student id: %s; name: %s; email: %s, gpa: %f", this.id, this.name, this.email, this.gpa);
        System.out.println(s);
    }
}
