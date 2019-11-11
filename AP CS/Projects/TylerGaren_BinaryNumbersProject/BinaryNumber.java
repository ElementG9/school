public class BinaryNumber implements BinaryNumberInterface {
    boolean[] bits = new boolean[9];
    // bits[0] = the negative flag.
    // bits[1 - 8] = the data.
    // int constructor.
    public BinaryNumber(int input) {
        if (input < -256 || input > 255)
            throw new IllegalArgumentException("Input must be between -256 and 255.");
        String binaryInput = BinaryTools.negDecToBin(input);
        bits = BinaryTools.binaryToBoolean(binaryInput);
    }
    // decimal, binary, or hex string constructor.
    public BinaryNumber(String input) {
        String numType = "dec";
        if (input.length() > 3) {
            if (input.substring(0, 2).equals("0x"))
                numType = "hex";
            else if (input.substring(0, 2).equals("0b"))
                numType = "bin";
        }
        if (numType == "bin" || numType == "hex")
            input = input.substring(2); // Remove the prefix.
        String binaryInput;
        if (numType == "dec")
            binaryInput = BinaryTools.negDecToBin(Integer.parseInt(input));
        else if (numType == "hex")
            binaryInput = BinaryTools.convertBase(input, 16, 2);
        else binaryInput = input;
        if (binaryInput.length() > 9)
            while (binaryInput.length() > 9)
                binaryInput = binaryInput.substring(1);
        else
            while (binaryInput.length() < 9)
                binaryInput = BinaryTools.binaryLeftPad(binaryInput);
        bits = BinaryTools.binaryToBoolean(binaryInput);
    }

    public BinaryNumber add(BinaryNumber num) {
        return new BinaryNumber(toInt() + num.toInt()); // Could use BinaryTools.add(), but simpler this way.
    }

    public BinaryNumber negate() {
        return new BinaryNumber(-1 * Math.abs(this.toInt()));
    }

    public BinaryNumber subtract(BinaryNumber num) {
        return new BinaryNumber(toInt() - num.toInt()); // Could use BinaryTools.add(), but simpler this way.
    }

    public BinaryNumber shiftLeft() {
        return new BinaryNumber("0b" + BinaryTools.booleanToBinary(bits).substring(1) + "0");
    }

    public BinaryNumber uShiftRight() {
        String bitsString = BinaryTools.booleanToBinary(bits);
        return new BinaryNumber("0b0" + bitsString.substring(0, bitsString.length() - 1));
    }

    public BinaryNumber and(BinaryNumber num) {
        String numString = num.toBinaryString();
        String result = "";
        for (int i = 2; i < numString.length(); i++)
            result += (numString.charAt(i) == '1') && (this.toBinaryString().charAt(i) == '1') ? "1" : "0";
        return new BinaryNumber("0b" + result);
    }

    public BinaryNumber or(BinaryNumber num) {
        String numString = num.toBinaryString();
        String result = "";
        for (int i = 2; i < numString.length(); i++)
            result += (numString.charAt(i) == '1') || (this.toBinaryString().charAt(i) == '1') ? "1" : "0";
        return new BinaryNumber("0b" + result);
    }

    public BinaryNumber xOr(BinaryNumber num) {
        String numString = num.toBinaryString();
        String result = "";
        for (int i = 2; i < numString.length(); i++)
            result += (numString.charAt(i) != this.toBinaryString().charAt(i)) ? "1" : "0";
        return new BinaryNumber("0b" + result);
    }

    public int toInt() {
        if (bits[0])
            return -1 * Integer.parseInt(BinaryTools.convertBase(BinaryTools.twosCompliment(BinaryTools.booleanToBinary(bits)), 2, 10));
        else return Integer.parseInt(BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 10));
    }

    public String toBinaryString() {
        return "0b" + BinaryTools.booleanToBinary(bits);
    }

    public String toHexString() {
        return "0x" + BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 16);
    }
}
