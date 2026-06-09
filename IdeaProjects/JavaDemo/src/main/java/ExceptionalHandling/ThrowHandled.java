package ExceptionalHandling;

public class ThrowHandled {
    public static void main(String[] args) {
        try {
            int age = 15;
            if (age < 18) {
                throw new ArithmeticException("Not eligible!");
            }
            System.out.println("You can vote.");
        }
        catch (ArithmeticException e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}