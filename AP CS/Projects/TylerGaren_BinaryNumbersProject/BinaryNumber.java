public class BinaryNumber {
    boolean[] bits;
    
    public BinaryNumber(int input) {
        String binaryString = decimalToBinary(input);
        bits = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++)
            bits[i] = binaryString.charAt(i) == '1';
    }
    
    // Conversion methods.
    // boolean[] to binary string.
    // binary string to boolean[]
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