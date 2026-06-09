package ExceptionalHandling;

public class ThrowExample {
    public static void main(String[] args) {
        int age = 15;
        if (age < 18) {
            // Manually throwing exception
            throw new ArithmeticException("You are not eligible to vote!");
        }
        System.out.println("You can vote.");
    }
}

