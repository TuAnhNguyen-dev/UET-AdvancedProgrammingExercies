class NumberWapper {
    private int number;

    public NumberWapper(int number) {
        setNumber(number);
    }

    public static void swap(NumberWapper n1, NumberWapper n2) {
        NumberWapper temp = n1;
        n1 = n2;
        n2 = temp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
