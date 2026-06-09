package Abstraction;
//  Abstract class
abstract class Vehicle {
    //  Abstract method (no body)
    // Only declaration, implementation will be given in child class
    abstract void start();
    // Concrete method (has body)
    void fuelType() {
        System.out.println("Vehicle uses fuel");
    }
}
//  Child class
class Car extends Vehicle {
    //  Providing implementation for abstract method
    void start() {
        System.out.println("Car starts with key");
    }
}
// Main class
public class AbstractExample {
    public static void main(String[] args) {
        // Cannot create object of abstract class
        // Vehicle v = new Vehicle();  → Not allowed
        // Create object of child class
        Vehicle v = new Car();  // Upcasting
        // Calling abstract method (implemented in Car)
        v.start();
        // Calling concrete method (defined in abstract class)
        v.fuelType();
    }
}
