import java.lang.Math; 
public class Line {
    Point a;
    Point b;
    
    public Line() {
        a = new Point();
        b = new Point(1,1);
    }
    
    public Line(double ax, double ay, double bx, double by) {
        a = new Point(ax, ay);
        b = new Point(bx, by);
    }
    
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
        return (getPointA().getY()-getPointB().getY())/(getPointA().getX()-getPointB().getX());
    }

    public double getLength() {
        return Math.sqrt(Math.pow(getPointA().getX()-getPointB().getX(),2) + Math.pow(getPointA().getY()-getPointB().getY(),2));
    }

    public Point getMidpoint() {
        return new Point((getPointA().getX()+getPointB().getX())/2,(getPointA().getY()+getPointB().getY())/2);
    }

    public double getPerpSlope() {
        return -1/getSlope();
    }

    public String toString() {
        return "("+getPointA().getX()+", "+getPointA().getY()+")"+" -> "+"("+getPointB().getX()+", "+getPointB().getY()+")";
    }

    public Line getPerpBisector() {
        Point perpA = new Point(-getPointA().getY(),getPointA().getX());
        Point perpB = new Point(-getPointB().getY(),getPointB().getX());
        Line perpLine = new Line(perpA,perpB);
        double midXDiff = getMidpoint().getX() - perpLine.getMidpoint().getX();
        double midYDiff = getMidpoint().getY() - perpLine.getMidpoint().getY();
        perpLine.a.x += midXDiff;
        perpLine.b.x += midXDiff;
        perpLine.a.y += midYDiff;
        perpLine.b.y += midYDiff;
        return perpLine;
    }
}