class Employee {
    String name;
    MyDate birthday;

    Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    Employee(Employee e) {
        this.name = e.name;
        this.birthday = new MyDate(e.birthday);
    }
}