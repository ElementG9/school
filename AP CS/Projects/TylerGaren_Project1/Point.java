public class Point {
    double x;
    double y;
    public Point(double _x, double _y) {
        x = _x;
        y = _y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}