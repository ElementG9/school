import java.util.*;
import java.io.File;
/**
 * Reads a maze from a text file, spaces are paths, the start is an "S" and the goal is a "$".
 * 
 * 
 * @author Kyle Gillette
 * @version 9/5/06
 */

public class MazeReader
{   // precondition : the file to be processed is text with spaces as the paths. 'S' must be in the file 
    // for the start position.
    // '$' must be in the file for the goal.  All other characters will be treated as walls.
    // postcondition : returns an ArrayList of points, where 'S' is the first point in the list, followed 
    // by points that represent the path.  The last point in the list will be the goal.
    public ArrayList<Point> getMaze(String fileName)
    {   Scanner sc = null;
        try
        {   sc = new Scanner(new File(fileName));
        }
        catch(Exception e)
        {   System.err.println("file " + fileName + "does not exist");
        }

        ArrayList<Point> points = new ArrayList<Point>(); 
        String line;
        int row = 0;
        Point endPoint = null;
        while( sc.hasNextLine() )
        {   line = sc.nextLine();
            // System.out.println( line + " " + line.length() );  for debugging purposes
            for( int col = 0; col < line.length(); col++ )
            {   if( line.charAt( col ) == ' ' )
                    points.add( new Point( row, col ) );     // appends each point onto the end of the list.
                if( line.charAt( col ) == 'S' )
                    points.add( 0, new Point( row, col ) );  // adds the start at the beginning.
                if( line.charAt( col ) == '$' )
                    endPoint = new Point( row, col );      // saves the goal to be added onto the end of the list later.
            } 
            row++;
        }
        points.add( endPoint );
        System.out.println( points );
        sc.close();
        return points;  // get actual list of points
    }

    // precondition : given a list of more than one point.
    // postcondition : returns true if there is a path of adjacent points from the first point to the last point, false otherwise.
    public static boolean isSolvable( ArrayList<Point> points )
    {
        Point start = points.get(0);
        Point end = points.get(points.size() - 1);
        return false;
    }
    public static ArrayList<Point> solve(ArrayList<Point> points) {
        // p is the current point.
        // points is all the points.
        Point start = points.get(0);
        Point end = points.get(points.size() - 1);
        ArrayList<Point> checked = new ArrayList<Point>();
        return checked;
    }
    private static ArrayList<Point> getAdjacents(Point p, ArrayList<Point> points) {
        ArrayList<Point> neighbors = new ArrayList<Point>();
        for(int i = 0; i < points.size(); i++)
            if(adjacent(p, points.get(i)))
                neighbors.add(points.get(i));
        return neighbors;
    }

    // postcondition : returns true if the to points are next to each other (not diagonally.)
    public static boolean adjacent( Point p1, Point p2 )
    {   
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) // The same point.
            return false;
        if (p1.getX() != p2.getX() && p1.getY() != p2.getY()) // Remove diagonals.
            return false;
        if (Math.abs(p1.getX() - p2.getX()) > 1 || Math.abs(p1.getY() - p2.getY()) > 1) // Remove points more than 1 unit away.
            return false;
        return true;
    }

    public static void testAdjacent()
    {
        Point center = new Point( 5, 3 );
        Point above = new Point( 4, 3 );
        Point below = new Point( 6, 3 );
        Point left = new Point( 5, 2 );
        Point right = new Point( 5, 4 );
        Point upLeft = new Point( 4, 2 );
        Point upRight = new Point( 4, 4 );
        Point downLeft = new Point( 6, 2 );
        Point downRight = new Point( 6, 4 );
        System.out.println( adjacent( center, above ) + " = true, above" );
        System.out.println( adjacent( center, below ) + " = true, below" );
        System.out.println( adjacent( center, right ) + " = true, right" );
        System.out.println( 
            adjacent( center, left ) + " = true, left" );
        System.out.println( adjacent( center, upLeft ) + " = false, up left" );
        System.out.println( adjacent( center, upRight ) + " = false, up right" );
        System.out.println( adjacent( center, downLeft ) + " = false, down left" );
        System.out.println( adjacent( center, downRight ) + " = false, down right" );
    } 
    // test 
    public static void main( String [] args )
    {   MazeReader mr;
        String testFile = "";
        for( int i = 1; i <= 5; i++ )
        {   mr = new MazeReader();
            testFile = "testmaze" + i + ".txt" ;
            // System.out.println( mr.getMaze("testmaze.txt") );  for debugging purposes
            if( isSolvable( mr.getMaze( testFile ) ))
                System.out.println( testFile + " is solvable" );
            else
                System.out.println( testFile + " is not solvable" );
        }
    }
}
