class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {
}

public class Main {
    public static void main(String[] args) {
// Bước 1: Upcasting (An toàn)
        Animal a = new Dog(); // Dog kế thừa Animal (lấy từ Bài 2)
// Bước 2: Downcasting (Rủi ro) - Hãy viết dòng này:
//        Cat c = (Cat) a;
// Bước 3: Gọi hàm
//        c.makeSound()

        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Đây không phải là Mèo!");
        }

//        Exception in thread "main" java.lang.ClassCastException: class Dog cannot be cast to class Cat (Dog and Cat are in unnamed module of loader 'app')
//        at Main.main(Main.java:29)
    }
}