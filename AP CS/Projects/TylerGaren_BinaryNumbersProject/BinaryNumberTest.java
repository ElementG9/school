public class BinaryNumberTest {
    public static void main() {
        System.out.println("--- Running test ---");
        int correct = 0;
        int total = 0;

        BinaryNumber num1 = new BinaryNumber(-5); // Test negatives and int constructor.
        BinaryNumber num2 = new BinaryNumber("0x0af"); // 0x0af = 175, Test hex constructor.

        boolean toIntTest = num1.toInt() == -5 && num2.toInt() == 175;
        if (test("toInt()", toIntTest))
            correct++;
        total++;

        boolean toBinaryStringTest = num1.toBinaryString().equals("0b111111011") && num2.toBinaryString().equals("0b010101111");
        if (test("toBinaryString()", toBinaryStringTest))
            correct++;
        total++;

        boolean toHexStringTest = num1.toHexString().equals("0x1fb") && num2.toHexString().equals("0xaf");
        if (test("toHexString()", toHexStringTest))
            correct++;
        total++;

        boolean addTest = num1.add(num2).toInt() == 170;
        if (test("add()", addTest))
            correct++;
        total++;

        boolean negateTest = num1.negate().toBinaryString().equals("0b000000100") && num2.negate().toBinaryString().equals("0b101010000");
        if (test("negate()", negateTest))
            correct++;
        total++;

        boolean subtractTest = num2.subtract(num1).toInt() == 180; // 175 - -5 = 180
        if (test("subtract()", subtractTest))
            correct++;
        total++;

        boolean shiftLeftTest = num1.shiftLeft().toBinaryString().equals("0b111110110") && num2.shiftLeft().toBinaryString().equals("0b101011110");
        if (test("shiftLeft()", shiftLeftTest))
            correct++;
        total++;

        boolean uShiftRightTest = num1.uShiftRight().toBinaryString().equals("0b011111101") && num2.uShiftRight().toBinaryString().equals("0b001010111");
        if (test("uShiftRight()", uShiftRightTest))
            correct++;
        total++;

        boolean andTest = num1.and(num2).toBinaryString().equals("0b010101011");
        if (test("and()", andTest))
            correct++;
        total++;

        boolean orTest = num1.or(num2).toBinaryString().equals("0b111111111");
        if (test("and()", orTest))
            correct++;
        total++;

        boolean xOrTest = num1.xOr(num2).toBinaryString().equals("0b101010100");
        if (test("xOr()", xOrTest))
            correct++;
        total++;

        System.out.println("--- Finished test ---");
        System.out.println("Correct: " + correct + ", Total: " + total + ", Percent Correct: " + (((double)correct / total) * 100) + "%");
    }

    private static boolean test(String name, boolean test) {
        System.out.print(name + ": ");
        if (test)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        return test;
    }
}
