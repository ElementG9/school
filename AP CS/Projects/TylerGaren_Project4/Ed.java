/**
 * A collection of methods to implement a simple line editor. 
 *
 * @author Kyle Gillette
 */

public interface Ed
{
   String getFirst();
   String getRest();
   Ed rightArrow();
   Ed leftArrow();
   Ed delete();
   Ed backspace();
   Ed insertString(String c);  
   Ed homeKey();
   Ed endKey();
   String toString();
}
