import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Grapher Panel creates a JFrame that displays Point, Line, and Polygon objects.
 * Objects to be drawn are stored in arrays and drawn in the paint method.
 * @author Rob Schreiber
 */
public class GrapherPanel extends JPanel{
    private Graphics g;
    private JFrame frame;
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Line> lines = new ArrayList<Line>();
    //private ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    /**
     * Creates and displays a JFrame and adds a GrapherPanel object to it.
     */
    public GrapherPanel() {
        super();
        frame = new JFrame("Grapher");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(500, 525);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    /**
     * Draws the GrapherPanel and stored geometric objects.
     *
     * @param g Graphics object used for drawing.
     */
    protected void paintComponent(Graphics g) {
        this.g = g;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.RED);
        g.drawLine(0, 250, 500, 250);
        g.drawLine(250, 0, 250, 500);
        for (int i = 0; i < 500; i += 25) {
            g.drawLine(i, 260, i, 240);
            g.drawLine(240, i, 260, i);
        }
        for (Point p : points) paintPoint(p);
        for (Line l : lines) paintLine(l);
        //for (Polygon p : polygons) paintPolygon(p);
    }
    /**
     * Draws a Point object on the GrapherPanel as a 5 pixel radius circle
     * centered on the Point object's x and y values scaled by 25 pixels
     * per integer value and centered around the origin at 250, 250.
     *
     * @param p The Point object to paint.
     */
    private void paintPoint(Point p) {
        g.setColor(Color.BLUE);
        g.fillOval(250 + (int)(p.getX()*25) - 5, 250 - (int)(p.getY()*25) - 5, 10, 10);
    }
    /**
     * Draws a Line object on the GrapherPanel as a 1 pixel wide line
     * ending on the points defining the Line object.
     *
     * @param The Line to paint.
     */
    private void paintLine(Line l) {
        g.setColor(Color.YELLOW);
        g.drawLine(250 + (int)(l.getPointA().getX() * 25),
                   250 - (int)(l.getPointA().getY() * 25),
                   250 + (int)(l.getPointB().getX() * 25),
                   250 - (int)(l.getPointB().getY() * 25));
    }
    /**
     * Adds a Point object to the list of Points to draw.
     *
     * @param The Point to be added to the draw list.
     */
    public void plotPoint(Point p) {
        points.add(p);
        this.repaint();
    }
    /**
     * Adds a Line object to the list of Lines to draw.
     *
     * @param The Line to be added to the draw list.
     */
    public void plotLine(Line l) {
        lines.add(l);
        this.repaint();
    }
}
