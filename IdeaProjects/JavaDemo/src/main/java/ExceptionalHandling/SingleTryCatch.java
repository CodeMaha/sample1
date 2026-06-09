package ExceptionalHandling;

public class SingleTryCatch {
    public static void main(String[] args) {
        try {
            // Risky code
            int a = 10;
            int b = 0;
            int result = a / b; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            // Exception handling code
            System.out.println("Cannot divide by zero!");
            //log txt-->logger file
        }
        System.out.println("Program continues...");
    }
}

