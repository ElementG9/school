import java.util.Random;
public class PolyParam {
    public static void main(String[] args) {
        Shape shp;
        Shape tri = new Triangle();
        Shape rect = new Rectangle();
        Random r = new Random();
        int flip = r.nextInt(2);
        if (flip == 0)
            shp = tri;
        else
            shp = rect;
        printArea(shp);
    }
    public static void printArea(Shape s) {
        System.out.println("area = " + s.area(5, 10));
    }
}
abstract class Shape {
    abstract double area(int a, int b);
}
class Triangle extends Shape {
    public double area(int x, int y) {
        return 0.5 * x * y;
    }
}
class Rectangle extends Shape {
    public double area(int x, int y) {
        return x * y;
    }
}