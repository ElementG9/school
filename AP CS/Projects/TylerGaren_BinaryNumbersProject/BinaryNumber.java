public class BinaryNumber {
    boolean[] bits = new boolean[9];
    // bits[0] = is negative flag
    // bits[1 - 8] = the data

    public BinaryNumber(String input) {
        input = input.toLowerCase(); // Convert capital letters in hex to lowercase.
        String numType;
        if (input.substring(0, 2).equals("0x")) {// A hex number.
            numType = "hex";
            input = input.substring(2); // Remove the prefix.
        } else if (input.substring(0, 2).equals("0b")) {// A binary number.
            numType = "bin";
            input = input.substring(1); // Remove the prefix.
        } else {
            numType = "dec";
        }
        int value = 0;
        System.out.println(input);
        if (numType.equals("hex")) {
            System.out.println(BinaryTools.convertBase(input, 16, 10));
            value = Integer.parseInt(BinaryTools.convertBase(input, 16, 10), 10);
        } else if (numType.equals("hex")) {
            System.out.println(BinaryTools.convertBase(input, 2, 10));
            value = Integer.parseInt(BinaryTools.convertBase(input, 2, 10));
        } else {
            System.out.println(input);
            value = Integer.parseInt(input);
        }
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

    // public int toInt() {
        // return Integer.parseInt(BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 10));
    // }

    // public String toBinaryString() {
        // return "0b" + BinaryTools.booleanToBinary(bits);
    // }

    // public String toHexString() {
        // return "0x" + BinaryTools.convertBase(BinaryTools.booleanToBinary(bits), 2, 16);
    // }
}
