public class BinaryNumber {
    boolean[] bits = new boolean[9];
    // bits[0] = is negative flag
    // bits[1 - 8] = the data
    public BinaryNumber(int input) {
        boolean negative;
        String binaryInput;
        if (input < -256 || input > 255)
            throw new IllegalArgumentException("Input must be between -256 and 255.");
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
        System.out.println(binaryInput);
        bits = BinaryTools.binaryToBoolean(binaryInput);
    }
    public BinaryNumber(String input) {
        // input = input.toLowerCase(); // Convert capital letters in hex to lowercase.
        // String numType;
        // if (input.length() > 3) {
            // if (input.substring(0, 2).equals("0b"))
                // numType = "bin";
            // else if (input.substring(0, 2).equals("0x"))
        // } else numType = "dec"; // Assume decimal if no prefix.
    }

    // public BinaryNumber add(BinaryNumber num) {
        // return new BinaryNumber(toInt() + num.toInt());
    // }

    // public BinaryNumber negate() {
        // boolean[] newBits = new boolean[bits.length];
        // for (int i = 0; i < bits.length; i++)
            // newBits[i] = bits[i];
        // for (int i = 0; i < newBits.length; i++)
            // newBits[i] = !newBits[i];
        // return new BinaryNumber("0b"+BinaryTools.booleanToBinary(newBits));
    // }

    // public BinaryNumber subtract(BinaryNumber num) {
        // return new BinaryNumber(toInt() - num.toInt());
    // }

    // public BinaryNumber shiftLeft() {
        // boolean[] newBits = new boolean[bits.length + 1];
        // for (int i = 0; i < bits.length; i++)
            // newBits[i] = bits[i];
        // newBits[newBits.length - 1] = false; // 0 comes in from the right.
        // return new BinaryNumber(BinaryTools.booleanToBinary(newBits));
    // }

    // public BinaryNumber uShiftRight() {
        // boolean[] newBits = new boolean[bits.length];
        // for (int i = 0; i < bits.length - 1; i++)
            // newBits[i + 1] = bits[i];
        // newBits[0] = false; // 0 comes in from the left.
        // return new BinaryNumber(BinaryTools.booleanToBinary(newBits));
    // }

    // public BinaryNumber and(BinaryNumber num) {
        // boolean[] newBits; // The bits to return.
        // boolean[] numBits = BinaryTools.binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        // boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        // for (int i = 0; i < bits.length; i++)
            // bitsClone[i] = bits[i];
        // // Make the bits to return equal in length to the biggest number.
        // if (numBits.length > bitsClone.length)
            // newBits = new boolean[numBits.length];
        // else newBits = new boolean[bitsClone.length];
        // // Pad the smaller number to be equal in length.
        // while(numBits.length < bitsClone.length)
            // numBits = BinaryTools.booleanLeftPad(numBits);
        // while(numBits.length > bitsClone.length)
            // bitsClone = BinaryTools.booleanLeftPad(bitsClone);

        // for (int i = 0; i < newBits.length; i++)
            // newBits[i] = numBits[i] && bitsClone[i];

        // return new BinaryNumber(BinaryTools.booleanToBinary(newBits));
    // }

    // public BinaryNumber or(BinaryNumber num) {
        // boolean[] newBits; // The bits to return.
        // boolean[] numBits = BinaryTools.binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        // boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        // for (int i = 0; i < bits.length; i++)
            // bitsClone[i] = bits[i];
        // // Make the bits to return equal in length to the biggest number.
        // if (numBits.length > bitsClone.length)
            // newBits = new boolean[numBits.length];
        // else newBits = new boolean[bitsClone.length];
        // // Pad the smaller number to be equal in length.
        // while(numBits.length < bitsClone.length)
            // numBits = BinaryTools.booleanLeftPad(numBits);
        // while(numBits.length > bitsClone.length)
            // bitsClone = BinaryTools.booleanLeftPad(bitsClone);

        // for (int i = 0; i < newBits.length; i++)
            // newBits[i] = numBits[i] || bitsClone[i];

        // return new BinaryNumber(BinaryTools.booleanToBinary(newBits));
    // }

    // public BinaryNumber xOr(BinaryNumber num) {
        // boolean[] newBits; // The bits to return.
        // boolean[] numBits = BinaryTools.binaryToBoolean(num.toBinaryString().substring(2)); // The bits from the other number.
        // boolean[] bitsClone = new boolean[bits.length]; // A clone of our bits.
        // for (int i = 0; i < bits.length; i++)
            // bitsClone[i] = bits[i];
        // // Make the bits to return equal in length to the biggest number.
        // if (numBits.length > bitsClone.length)
            // newBits = new boolean[numBits.length];
        // else newBits = new boolean[bitsClone.length];
        // // Pad the smaller number to be equal in length.
        // while(numBits.length < bitsClone.length)
            // numBits = BinaryTools.booleanLeftPad(numBits);
        // while(numBits.length > bitsClone.length)
            // bitsClone = BinaryTools.booleanLeftPad(bitsClone);

        // for (int i = 0; i < newBits.length; i++)
            // newBits[i] = numBits[i] != bitsClone[i];

        // return new BinaryNumber(BinaryTools.booleanToBinary(newBits));
    // }

    public int toInt() {
        if (bits[0])
            return -1 * Integer.parseInt(BinaryTools.convertBase(BinaryTools.twosCompliment(BinaryTools.booleanToBinary(bits)), 2, 10));
        else return Integer.parseInt(BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 10));
    }

    // public String toBinaryString() {
        // return "0b" + BinaryTools.booleanToBinary(bits);
    // }

    // public String toHexString() {
        // return "0x" + BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 16);
    // }
}
