package task1;

import java.util.Scanner;

public class Circle implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void Draw() {
        System.out.println("Drawing a circle with radius: " + radius);
        System.out.println("Hmm, lets see how big it is...");
        System.out.println("Its area is " + calculateArea());
        System.out.println("and the circumference is: " + calculateCircumference());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of a circle I should draw: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        circle.Draw();
        scanner.close();
    }
}
