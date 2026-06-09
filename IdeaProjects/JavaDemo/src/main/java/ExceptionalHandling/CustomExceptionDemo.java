package ExceptionalHandling;
class InsufficientBalanceException extends Exception {
    // Step 2: Constructor
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    // Method that may throw custom exception
    static void withdraw(int amount) throws InsufficientBalanceException {
        int balance = 5000;
        if (amount > balance) {
            // Step 3: Throw custom exception
            throw new InsufficientBalanceException("Balance is low!");
        }
        System.out.println("Withdrawal successful!");
    }
    public static void main(String[] args) {
        try {
            withdraw(7000); // calling method
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}
