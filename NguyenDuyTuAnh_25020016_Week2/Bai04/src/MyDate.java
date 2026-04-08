class MyDate {
    int day;
    int month;
    int year;

    MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    MyDate(MyDate d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }
}