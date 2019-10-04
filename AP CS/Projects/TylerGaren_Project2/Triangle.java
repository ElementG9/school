import java.lang.Math;
public class Triangle {
    Line a;
    Line b;
    Line c;
    
    public Triangle(double ax, double ay, double bx, double by, double cx, double cy) {
        Point pointA = new Point(ax, ay);
        Point pointB = new Point(bx, by);
        Point pointC = new Point(cx, cy);
        a = new Line(pointA, pointB);
        b = new Line(pointB, pointC);
        c = new Line(pointC, pointA);
    }

    public Triangle(Point _a, Point _b, Point _c) {
        a = new Line(_a, _b);
        b = new Line(_b, _c);
        c = new Line(_c, _a);
    }

    public Point getPointA() {
        return a.getPointA();
    }

    public Point getPointB() {
        return b.getPointA();
    }

    public Point getPointC() {
        return c.getPointA();
    }

    public Line[] getSides() {
        Line[] sides = {a, b, c};
        return sides;
    }

    public Point getCenter() {
        Point pointA = a.getPointA();
        Point pointB = b.getPointA();
        Point pointC = c.getPointA();
        double centerX = (pointA.getX() + pointB.getX() + pointC.getX())/3;
        double centerY = (pointA.getY() + pointB.getY() + pointC.getY())/3;
        return new Point(centerX, centerY);
    }

    public double getPerimeter() {
        double length = 0;
        length += a.getLength();
        length += b.getLength();
        length += c.getLength();
        return length;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s*(s-a.getLength())*(s-b.getLength())*(s-c.getLength()));
    }
    public Line getAltitude() {
        return new Line();
    }

    public String toString() {
        return "("+getPointA().x+", "+getPointA().y+") <-> ("+getPointB().x+", "+getPointB().y+") <-> ("+getPointC().x+", "+getPointC().y+")";
    }
}