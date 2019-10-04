import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * EditorPanel houses an Editor in a GUI.
 * Features implemented are:
 * <ul>
 * <li>Move Left/Right</li>
 * <li>Go to home/end</li>
 * <li>Backspace</li>
 * <li>Type in Unicode Characters</li>
 * </ul>
 * Mouse actions are not implemented.
 * 
 * EditorPanel creates its own frame.
 * 
 * @author Tyler Middleton (with minor edits by Kyle Gillette) 
 * @version 10-4-10
 */
public class EditorPanel extends JPanel implements KeyListener
{
    private Ed editor;
    private JFrame frame;
    private static final int CURSOR_WIDTH = 5;  // KG
    private static final int ED_WIDTH = 1000;  // KG
    private static final int ED_HEIGHT = 100;  // KG
    
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        Ed ed = editor;
        if (keycode == KeyEvent.VK_LEFT) {
            ed = editor.leftArrow();
        } else if (keycode == KeyEvent.VK_RIGHT) {
            ed = editor.rightArrow();
        } else if (keycode == KeyEvent.VK_HOME) {
            ed = editor.homeKey();
        } else if (keycode == KeyEvent.VK_END) {
            ed = editor.endKey();
        } else if (keycode == KeyEvent.VK_BACK_SPACE) {
            ed = editor.backspace();
        } else if (keycode == KeyEvent.VK_DELETE) {        // KG added delete functionality
            ed = editor.delete();    
        } else if (e.getKeyChar() != e.CHAR_UNDEFINED) {
            ed = editor.insertString("" + e.getKeyChar());
        }
        editor = ed;
        this.repaint();
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
    public void keyTyped(KeyEvent e) {
        
    }
    
    // Added by KG 10/6/2010
    public EditorPanel()
    {  this("", "");
    }
    
    public EditorPanel( String beginning, String end ) {
        super();
        //this.setSize(0,0);  // Original values 500, 300. Tyler, what does this do? The frame is set later. -- KG
        /* The JPanel is a container to put lots of other controls, boxes, etc.  JFrame seems to be all that you need.
         * If you were to add a reset button, then the JPanel may become useful.
         */
        editor = new Editor(beginning,end);
        //this.setVisible(true);  ditto -- KG
        //this.repaint();         ditto -- KG
        frame = new JFrame("My Editor");
        frame.getContentPane().add(this,BorderLayout.CENTER);
        frame.pack();
        frame.setSize(ED_WIDTH, ED_HEIGHT);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        int w = this.getWidth();
        int h = this.getHeight();
        g.fillRect(0,0,w,h);
        String s = editor.getFirst()+editor.getRest();
        FontMetrics fm = g.getFontMetrics();
        int fh = fm.getAscent();
        int m = h/2+fh/2;
        g.setColor(Color.black);
        g.drawString(editor.getFirst(),0,m);
        int gap = fm.stringWidth(editor.getFirst());
        g.setColor(Color.red);
        g.fillRect(gap,m-fh,CURSOR_WIDTH,fh);
        g.setColor(Color.black);
        g.drawString(editor.getRest(),gap+CURSOR_WIDTH,m);
    }
}
