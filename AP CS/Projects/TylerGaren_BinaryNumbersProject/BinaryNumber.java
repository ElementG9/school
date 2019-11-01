public class BinaryNumber implements BinaryNumberInterface {
    boolean[] bits; // Most significant digits first.

    public BinaryNumber(int input) {
        String binaryString = convertBase(Integer.toString(input), 10, 2);
        bits = binaryToBoolean(binaryString);
        int value = Integer.parseInt(convertBase(booleanToBinary(bits), 2, 10));
        if (value < -256 || value > 255)
            throw new IllegalArgumentException("Number must be between -256 & 255");
    }

    public BinaryNumber(String input) {
        input = input.toLowerCase(); // Convert capital letters in hex to lowercase.
        boolean isBinary;
        if (input.substring(0, 2).equals("0x")) // A hex number.
            isBinary = false;
        else if (input.substring(0, 2).equals("0b")) // A binary number.
            isBinary = true;
        else throw new IllegalArgumentException("Input must be prefixed by '0x' for a hex number, or '0b' for a binary number");
        input = input.substring(2); // Remove the prefix.
        bits = new boolean[input.length()];
        if (!isBinary)
            bits = binaryToBoolean(convertBase(input, 16, 2));
        else
            bits = binaryToBoolean(input);
        int value = Integer.parseInt(convertBase(booleanToBinary(bits), 2, 10));
        if (value < -256 || value > 255)
            throw new IllegalArgumentException("Number must be between -256 & 255");
    }

    public BinaryNumber add(BinaryNumber num) {
        return new BinaryNumber(toInt() + num.toInt());
    }

    public BinaryNumber negate() {
        boolean[] newBits = new boolean[bits.length];
        for (int i = 0; i < bits.length; i++)
            newBits[i] = bits[i];
        for (int i = 0; i < newBits.length; i++)
            newBits[i] = !newBits[i];
        return new BinaryNumber(booleanToBinary(newBits));
    }

    public BinaryNumber subtract(BinaryNumber num) {
        return new BinaryNumber(toInt() - num.toInt());
    }

    public BinaryNumber shiftLeft() {
        boolean[] newBits = new boolean[bits.length + 1];
        for (int i = 0; i < bits.length; i++)
            newBits[i] = bits[i];
        newBits[newBits.length - 1] = false; // 0 comes in from the right.
        return new BinaryNumber(booleanToBinary(newBits));
    }

    public BinaryNumber uShiftRight() {
        boolean[] newBits = new boolean[bits.length];
        for (int i = 0; i < bits.length - 1; i++)
            newBits[i + 1] = bits[i];
        newBits[0] = false; // 0 comes in from the left.
        return new BinaryNumber(booleanToBinary(newBits));
    }

    public BinaryNumber and(BinaryNumber num) {
        boolean[] newBits; // The bits to return.
        boolean[] numBits = binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        for (int i = 0; i < bits.length; i++)
            bitsClone[i] = bits[i];
        // Make the bits to return equal in length to the biggest number.
        if (numBits.length > bitsClone.length)
            newBits = new boolean[numBits.length];
        else newBits = new boolean[bitsClone.length];
        // Pad the smaller number to be equal in length.
        while(numBits.length < bitsClone.length)
            numBits = booleanLeftPad(numBits);
        while(numBits.length > bitsClone.length)
            bitsClone = booleanLeftPad(bitsClone);

        for (int i = 0; i < newBits.length; i++)
            newBits[i] = numBits[i] && bitsClone[i];

        return new BinaryNumber(booleanToBinary(newBits));
    }

    public BinaryNumber or(BinaryNumber num) {
        boolean[] newBits; // The bits to return.
        boolean[] numBits = binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        for (int i = 0; i < bits.length; i++)
            bitsClone[i] = bits[i];
        // Make the bits to return equal in length to the biggest number.
        if (numBits.length > bitsClone.length)
            newBits = new boolean[numBits.length];
        else newBits = new boolean[bitsClone.length];
        // Pad the smaller number to be equal in length.
        while(numBits.length < bitsClone.length)
            numBits = booleanLeftPad(numBits);
        while(numBits.length > bitsClone.length)
            bitsClone = booleanLeftPad(bitsClone);

        for (int i = 0; i < newBits.length; i++)
            newBits[i] = numBits[i] || bitsClone[i];

        return new BinaryNumber(booleanToBinary(newBits));
    }

    public BinaryNumber xOr(BinaryNumber num) {
        boolean[] newBits; // The bits to return.
        boolean[] numBits = binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        for (int i = 0; i < bits.length; i++)
            bitsClone[i] = bits[i];
        // Make the bits to return equal in length to the biggest number.
        if (numBits.length > bitsClone.length)
            newBits = new boolean[numBits.length];
        else newBits = new boolean[bitsClone.length];
        // Pad the smaller number to be equal in length.
        while(numBits.length < bitsClone.length)
            numBits = booleanLeftPad(numBits);
        while(numBits.length > bitsClone.length)
            bitsClone = booleanLeftPad(bitsClone);

        for (int i = 0; i < newBits.length; i++)
            newBits[i] = numBits[i] != bitsClone[i];

        return new BinaryNumber(booleanToBinary(newBits));
    }

    public int toInt() {
        return Integer.parseInt(convertBase(booleanToBinary(bits), 2, 10));
    }

    public String toBinaryString() {
        return "0b" + booleanToBinary(bits);
    }

    public String toHexString() {
        return "0x" + convertBase(booleanToBinary(bits), 2, 16);
    }
    // Pad left side with zeroes.
    private boolean[] booleanLeftPad(boolean[] bools) {
        boolean[] newBools = new boolean[bools.length + 1];
        for (int i = 0; i < bools.length; i++)
            newBools[i + 1] = bools[i];
        newBools[0] = false;
        return newBools;
    }

    private String binaryLeftPad(String num) {
        return "0" + num;
    }
    // Conversion methods.
    // Boolean[] to binary string.
    private String booleanToBinary(boolean[] bools) {
        String out = "";
        for (int i = 0; i < bools.length; i++)
            out += bools[i] ? "1" : "0";
        return out;
    }
    // Binary string to boolean[]
    private boolean[] binaryToBoolean(String num) {
        boolean[] bools = new boolean[num.length()];
        for (int i = 0; i < num.length(); i++)
            bools[i] = num.charAt(i) == '1';
        return bools;
    }
    // Universal base converter.
    private static String convertBase(String num, int fromBase, int toBase) {
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
}
