public interface BinaryNumberInterface {
    BinaryNumber add(BinaryNumber x);
    BinaryNumber negate();
    BinaryNumber subtract(BinaryNumber x);
    BinaryNumber shiftLeft();
    BinaryNumber uShiftRight();
    BinaryNumber and(BinaryNumber x);
    BinaryNumber or(BinaryNumber x);
    BinaryNumber xOr(BinaryNumber x);
    int toInt();
    String toBinaryString();
    String toHexString();
}