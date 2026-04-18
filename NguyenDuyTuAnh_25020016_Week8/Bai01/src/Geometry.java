interface Shape {
    double getArea();
}

public class Geometry {
    public void test() {
        double a = 4.5;
        double b = 5.0;

        Shape rectangle = new Rectangle(a, b);
        Shape triangle = new Triangle(a, b);
        Shape circle = new Circle(a);

        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Area of Triangle: " + triangle.getArea());
        System.out.println("Area of Circle: " + circle.getArea());
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
