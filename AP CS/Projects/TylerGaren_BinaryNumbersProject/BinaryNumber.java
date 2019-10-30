public class BinaryNumber implements BinaryNumberInterface {
    boolean[] bits; // Most significant digits first.

    public BinaryNumber(int input) {
        String binaryString = decimalToBinary(input);
        bits = binaryToBoolean(binaryString);
        int value = binaryToDecimal(booleanToBinary(bits));
        if (value < -256 || value > 255)
            throw new IllegalArgumentException("Number must be between -256 & 255");
    }

    public BinaryNumber(String input) {
        input = input.toLowerCase(); // Convert capital letters in hex to lowercase.
        boolean isBinary = true;
        bits = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '0':
                case '1':
                break;
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                isBinary = false;
                break;
                default:
                throw new IllegalArgumentException("Input must be 0-9, a-f.");
            }
        }
        if (!isBinary)
            bits = binaryToBoolean(hexToBinary(input));
        else
            bits = binaryToBoolean(input);
        int value = binaryToDecimal(booleanToBinary(bits));
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
        boolean[] numBits = binaryToBoolean(num.toBinaryString()); // The bits from the other number.
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
        boolean[] numBits = binaryToBoolean(num.toBinaryString()); // The bits from the other number.
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
        boolean[] numBits = binaryToBoolean(num.toBinaryString()); // The bits from the other number.
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
        return binaryToDecimal(booleanToBinary(bits));
    }

    public String toBinaryString() {
        return booleanToBinary(bits);
    }

    public String toHexString() {
        return binaryToHex(booleanToBinary(bits));
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
    // From decimal.
    private String decimalToBinary(int num) {
        return Integer.toBinaryString(num);
    }

    private String decimalToHex(int num) {
        return Integer.toHexString(num);
    }
    // From hex.
    private int hexToDecimal(String num) {
        return Integer.parseInt(num, 16);
    }

    private String hexToBinary(String num) {
        return decimalToBinary(hexToDecimal(num));
    }
    // From binary.
    private int binaryToDecimal(String num) {
        return Integer.parseInt(num, 2);
    }

    private String binaryToHex(String num) {
        return decimalToHex(binaryToDecimal(num));
    }
}
