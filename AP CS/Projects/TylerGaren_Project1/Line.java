import java.lang.Math; 
public class Line {
    Point a;
    Point b;
    public Line(Point _a, Point _b) {
        a = _a;
        b = _b;
    }

    public Point getPointA() {
        return a;
    }

    public Point getPointB() {
        return b;
    }

    public double getSlope() {
        return (a.y-b.y)/(a.x-b.x);
    }

    public double getLength() {
        return Math.sqrt(Math.pow(a.x-b.x,2) + Math.pow(a.y-b.y,2));
    }

    public Point getMidpoint() {
        return new Point((a.x+b.x)/2,(a.y+b.y)/2);
    }

    public double getPerpSlope() {
        return -1/getSlope();
    }

    public String toString() {
        return "("+a.x+", "+a.y+")"+" -> "+"("+b.x+", "+b.y+")";
    }

    public Line getPerpBisector() {
        Point perpA = new Point(-a.y,a.x);
        Point perpB = new Point(-b.y,b.x);
        Line perpLine = new Line(perpA,perpB);
        double midXDiff = getMidpoint().x - perpLine.getMidpoint().x;
        double midYDiff = getMidpoint().y - perpLine.getMidpoint().y;
        perpLine.a.x += midXDiff;
        perpLine.b.x += midXDiff;
        perpLine.a.y += midYDiff;
        perpLine.b.y += midYDiff;
        return perpLine;
    }
}