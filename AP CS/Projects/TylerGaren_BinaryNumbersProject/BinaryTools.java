// BinaryTools exists to simplify the functions in BinaryNumber while still being simple.
import java.lang.*;
public class BinaryTools {
    // Convert 0-15 to 0x0-0xf.
    public static char decimalToHexChar(int num) {
        if (num >= 0 && num < 10)
            return (char)(num + '0');
        else if (num == 10)
            return 'A';
        else if (num == 11)
            return 'B';
        else if (num == 12)
            return 'C';
        else if (num == 13)
            return 'D';
        else if (num == 14)
            return 'E';
        else if (num == 15)
            return 'F';
        else return '!'; // Return ! if num greater than 16 or less than 0.
    }    
    // Convert 0x0-0xf to 0-15.
    public static int hexCharToDecimal(char num) {
        if (num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5' || num == '6' || num == '7' || num == '8' || num == '9')
            return Integer.parseInt(Character.toString(num));
        else if (num == 'a')
            return 10;
        else if (num == 'A')
            return 10;
        else if (num == 'b')
            return 11;
        else if (num == 'B')
            return 11;
        else if (num == 'c')
            return 12;
        else if (num == 'C')
            return 12;
        else if (num == 'd')
            return 13;
        else if (num == 'd')
            return 13;
        else if (num == 'e')
            return 14;
        else if (num == 'e')
            return 14;
        else if (num == 'f')
            return 15;
        else if (num == 'F')
            return 15;
        else return -1; // Return -1 if num greater than 0xf or less than 0x0.
    }    
    // Convert bases. num is expected to be positive, negatives are untested.
    public static String convertBase(String num, int fromBase, int toBase) {
        num = num.toLowerCase();
        if (fromBase < 2 || fromBase > 16)
            return null;
        if (toBase < 2 || toBase > 16)
            return null;
        if (fromBase == toBase)
            return num;
        int decimal = 0;
        for(int i = 0; i< num.length(); i++)
            decimal += hexCharToDecimal(num.charAt(i)) * Math.pow(fromBase, (num.length() - 1) - i);
        if (toBase == 10)
            return Integer.toString(decimal);
        String out = "";
        while (decimal > 0) {
            int result = (int) Math.floor(decimal / toBase);
            int remainder = decimal - (int) Math.floor(decimal / toBase) * toBase;
            decimal = result;
            out = decimalToHexChar(remainder) + out; // Append to beginning to avoid needing to reverse.
        }
        return out;
    }
    // Boolean[] to binary string. [true, false, true] to "101".
    public static String booleanToBinary(boolean[] bools) {
        String out = "";
        for (int i = 0; i < bools.length; i++)
            out += bools[i] ? "1" : "0";
        return out;
    }
    // Binary string to boolean[]. "101" to [true, false, true].
    public static boolean[] binaryToBoolean(String num) {
        boolean[] bools = new boolean[num.length()];
        for (int i = 0; i < num.length(); i++)
            bools[i] = num.charAt(i) == '1';
        return bools;
    }
    // Pad binary string. "101" to "0101".
    public static String binaryLeftPad(String num) {
        return "0" + num;
    }
    // Converts decimal numbers to binary, with negatives.
    public static String negDecToBin(int input) {
        boolean negative;
        String binaryInput;
        if (input < 0) {
            negative = true;
            input *= -1;
            binaryInput = BinaryTools.convertBase(Integer.toString(input), 10, 2);
        } else {
            negative = false;
            binaryInput = BinaryTools.convertBase(Integer.toString(input), 10, 2);
        }
        while (binaryInput.length() < 9)
            binaryInput = "0" + binaryInput;
        if (negative) {
            binaryInput = BinaryTools.twosCompliment(binaryInput);
        }
        return binaryInput;
    }
    // Negates a binary string. "101" to "010".
    public static String negate(String num) {
        String out = "";
        for(int i = 0; i < num.length(); i++)
            out += num.charAt(i) == '1' ? "0" : "1";
        return out;
    }
    // Adds two binary numbers.
    public static String add(String num1, String num2) {
        String out = "";
        while (num1.length() < num2.length())
            num1 = binaryLeftPad(num1);
        while (num2.length() < num1.length())
            num2 = binaryLeftPad(num2);
        boolean carry = false;
        for(int i = num1.length() - 1; i > -1; i--) {
            int temp = 0;
            if (carry)
                temp++;
            if(num1.charAt(i) == '1')
                temp++;
            if(num2.charAt(i) == '1')
                temp++;
            if (temp == 0) {
                out = "0" + out;
                carry = false;
            } else if (temp == 1) {
                out = "1" + out;
                carry = false;
            } else if (temp == 2) {
                out = "0" + out;
                carry = true;
            } else if (temp == 3) {
                out = "1" + out;
                carry = true;
            }
        }
        if (carry)
            out = "1" + out;
        return out;
    }
    // Two's compliment of a binary string.
    public static String twosCompliment(String num1) {
        return add(negate(num1), "1");
    }
}
