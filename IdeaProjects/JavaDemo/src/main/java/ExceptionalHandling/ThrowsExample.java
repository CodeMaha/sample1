package ExceptionalHandling;

public class ThrowsExample {

    // Method declaring exception using throws
    static void checkNumber(int num) throws ArithmeticException {

        if (num < 0) {
            throw new ArithmeticException("Number is negative!");
        }

        System.out.println("Valid number: " + num);
    }

    public static void main(String[] args) {

        // Calling method without handling
        checkNumber(-5);

        System.out.println("End of main method");
    }
}