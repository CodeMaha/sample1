package FinalDemo;
// The 'final' keyword means this class cannot be inherited
// We use it for security/design control where behavior should not be changed

final class PaymentProcessor {
    // Method to process payment
    void processPayment() {
        System.out.println("Payment processed successfully");
    }
}

// This will cause a compile-time error
/*class CreditCardPayment extends PaymentProcessor {
    // Error: Cannot inherit from final class 'PaymentProcessor'
}*/

public class FinalClassDemo {
    public static void main(String[] args) {
        // Creating object of final class
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment();
        // Output: Payment processed successfully
    }
}

