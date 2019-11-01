import java.lang.*;
public class BaseConverter {
    private static char decimalToHexChar(int num) {
        if (num > 0 && num < 10)
            return (char)(num + '0');
        else if (num == 10)
            return 'a';
        else if (num == 11)
            return 'b';
        else if (num == 12)
            return 'c';
        else if (num == 13)
            return 'd';
        else if (num == 14)
            return 'e';
        else if (num == 15)
            return 'f';
        else return '!'; // Return ! if num greater than 16 or less than 0.
    }    

    private static int hexCharToDecimal(char num) {
        if (num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5' || num == '6' || num == '7' || num == '8' || num == '9')
            return Integer.parseInt(Character.toString(num));
        else if (num == 'a')
            return 10;
        else if (num == 'b')
            return 11;
        else if (num == 'c')
            return 12;
        else if (num == 'd')
            return 13;
        else if (num == 'e')
            return 14;
        else if (num == 'f')
            return 15;
        else return -1; // Return -1 if num greater than 0xf or less than 0x0.
    }    

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
        System.out.println(decimal);
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
}
