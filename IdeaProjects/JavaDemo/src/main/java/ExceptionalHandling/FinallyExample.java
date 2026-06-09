package ExceptionalHandling;

public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            int a = 10 / 0; // Exception occurs
        } catch (ArithmeticException e) {
            System.out.println("Exception caught!");
        }
        finally {
            // This block ALWAYS executes
            System.out.println("Finally block executed!");
        }
        System.out.println("End of program");
    }
}
