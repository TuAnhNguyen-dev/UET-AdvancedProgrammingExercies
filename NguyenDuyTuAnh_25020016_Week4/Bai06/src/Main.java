public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {5, 1, 3, 2};
        ArrayUtils.sort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + (i < intArray.length - 1 ? " " : ""));
        }
        System.out.println();

        String[] strArray = {"Java", "C++", "Python"};
        ArrayUtils.sort(strArray);

        for (int i = 0; i < strArray.length; i++) {
            System.out.print(strArray[i] + (i < strArray.length - 1 ? " " : ""));
        }
        System.out.println();

        Student[] students = {new Student("Nguyen Duy Tu Anh"), new Student("Le Ngoc Diep"), new Student("Trinh Khanh Duc")};
        ArrayUtils.sort(students);

        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getName() + (i < students.length - 1 ? ", " : "\n"));
        }
    }
}