import javax.swing.*;
import java.awt.*;

/**
 * @author William Dubel
 * @version 01.31.2004
 */

class FractalPanel extends JPanel {
    private String type;
    private Color foreground, background;

    public FractalPanel(String type, Color foreground, Color background) {
        super();
        this.type = type;
        this.foreground = foreground;
        this.background = background;
    }
    //write this method
    private static Coord mid(Coord a, Coord b) {
        return new Coord((a.x+b.x)/2, (a.y+b.y)/2);
    }

    private static Coord third(Coord a, Coord b) {
        return new Coord((b.x-a.x)/3+a.x, (b.y-a.y)/3+a.y);
    }

    // Write this method
    private static double dist(Coord a, Coord b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private static void drawKochSide(Graphics2D g2, Coord a, Coord b) {
        //if lines are only 1 pixels in length
        if (dist(a,b)<=1) {
            g2.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
        } else {
            Coord c = new Coord(Math.cos(Math.PI/3.0 + Math.atan2(b.y-a.y,b.x-a.x))*
                    (dist(a,b)/3)+third(a,b).x,
                    Math.sin(Math.PI/3.0 + Math.atan2(b.y-a.y,b.x-a.x))*
                    (dist(a,b)/3)+third(a,b).y);

            drawKochSide(g2, a, third(a,b));
            drawKochSide(g2, third(a,b), c);
            drawKochSide(g2, c, mid(third(a,b), b));
            drawKochSide(g2, mid(third(a,b),b), b);
        }
    }
    //Write this method
    private static void drawSierpinski(Graphics2D g2, Coord a, Coord b, Coord c) {
        g2.drawLine((int) a.x,(int) a.y,(int) b.x,(int) b.y);
        g2.drawLine((int) b.x,(int) b.y,(int) c.x,(int) c.y);
        g2.drawLine((int) c.x,(int) c.y,(int) a.x,(int) a.y);
        if (dist(a,b) > 2) {
            Coord A = mid(b, c);
            Coord B = mid(c, a);
            Coord C = mid(a, b);
            g2.drawLine((int) A.x,(int) A.y,(int) B.x,(int) B.y);
            g2.drawLine((int) B.x,(int) B.y,(int) C.x,(int) C.y);
            g2.drawLine((int) C.x,(int) C.y,(int) A.x,(int) A.y);
            drawSierpinski(g2, C, b, A);
            drawSierpinski(g2, B, A, c);
            drawSierpinski(g2, a, C, B);
        }
    }

    public void paintComponent(Graphics g) {
        double w = getSize().getWidth();
        double h = getSize().getHeight();

        g.setColor(background);
        g.fillRect(0, 0, (int)w, (int)h);
        g.setColor(foreground);
        Graphics2D g2 = (Graphics2D)g;

        if ("Sierpinski".equalsIgnoreCase(type)) {
            drawSierpinski(g2, new Coord(0, h), new Coord(w/2.0, 0), new Coord(w, h));
        } else {
            // Make sure that the koch snowflake is proportioned and centered correctly
            double ox = 0.0, oy = 0.0;

            if ((w*2.0*Math.sqrt(3.0))<h*3.0) {
                h = (w * 2.0 * Math.sqrt(3.0)) / 3.0;
                oy = (getSize().getHeight()-1 - h)/2.0;
            }
            if ((w*2.0*Math.sqrt(3.0))>h*3.0) {
                w = (h * 3.0) / (2 * Math.sqrt(3.0));
                ox = (getSize().getWidth()-1 - w)/2.0;
            }
            drawKochSide(g2, new Coord(w/2.0+ox, oy), new Coord(ox, h*0.75+oy));
            drawKochSide(g2, new Coord(w+ox, h*0.75+oy), new Coord(w/2.0+ox, oy));
            drawKochSide(g2, new Coord(ox, h*0.75+oy), new Coord(w+ox, h*0.75+oy));
        }
    }
}

class Coord {
    public double x, y;
    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class GraphWindow extends JFrame {
    private Container c;
    public GraphWindow() {
        super("Fractal Maker");
        c = getContentPane();
        c.add(new FractalPanel("Sierpinski", Color.white, Color.darkGray));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,520);
    }
}

public class Fractal extends JApplet {
    public void init() {
        Container c = getContentPane();
        c.add(new FractalPanel("Sierpinski", Color.blue, Color.white));
    }

    public static void main(String [] args) {
        GraphWindow app = new GraphWindow();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frame = app.getSize();

        if (frame.height > screen.height)
            frame.height = screen.height;
        if (frame.width > screen.width)
            frame.width = screen.width;

        app.setLocation((screen.width - frame.width) / 2, (screen.height - frame.height) / 2);
        app.setVisible(true);
    }
}