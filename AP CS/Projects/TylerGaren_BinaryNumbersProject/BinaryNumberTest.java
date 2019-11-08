public class BinaryNumberTest {
    public static void main() {
        System.out.println("--- Running test ---");
        int correct = 0;
        int total = 0;
        
        BinaryNumber num1 = new BinaryNumber(-5); // Test negatives and int constructor.
        BinaryNumber num2 = new BinaryNumber("0x0af"); // 0x0af = 175, Test hex constructor.
        
        System.out.print("toInt(): ");
        if (num1.toInt() != -5 || num2.toInt() != 175)
            System.out.println("FAIL");
        else {
            System.out.println("PASS");
            correct++;
        }
        total++;
        
        System.out.print("toBinaryString(): ");
        if (!num1.toBinaryString().equals("0b111111011") || !num2.toBinaryString().equals("0b010101111"))
            System.out.println("FAIL");
        else {
            System.out.println("PASS");
            correct++;
        }
        total++;
        
        System.out.print("toHexString(): ");
        if (!num1.toHexString().equals("0x1fb") || !num2.toHexString().equals("0xaf"))
            System.out.println("FAIL");
        else {
            System.out.println("PASS");
            correct++;
        }
        total++;
        
        System.out.print("add(): ");
        if (num1.add(num2).toInt() != 170)
            System.out.println("FAIL");
        else {
            System.out.println("PASS");
            correct++;
        }
        total++;
        
        System.out.print("negate(): ");
        if (!num1.negate().toBinaryString().equals("0b000000100") || !num2.negate().toBinaryString().equals("0b101010000"))
            System.out.println("FAIL");
        else {
            System.out.println("PASS");
            correct++;
        }
        total++;
        
        System.out.println("--- Finished test ---");
        System.out.println("Correct: " + correct + ", Total: " + total + ", Percent Correct: " + (((double)correct / total) * 100) + "%");
    }
}
