public class Recursion {
    public static int power(int base, int exp) {
        if (exp == 0)
            return 1;
        else return base * power(base, exp - 1);
    }
    public static int factorial(int num) {
        if (num == 1)
            return 1;
        else return num * factorial(num - 1);
    }
    public static void stackOverflow(int count) {
        System.out.println(count);
        stackOverflow(count + 1);
    }
    public static int fibonacci(int num) {
        if (num <= 1)
            return 0;
        else if (num == 2)
            return 1;
        else return fibonacci(num - 2) + fibonacci(num - 1);
    }
}