package Abstraction;

// Interface (100% abstraction by default)
interface Vehicles {

    // Abstract method (no body)
    // By default: public and abstract
    void start();

    // Another abstract method
    void stop();
}

// Implementing class
class Cars implements Vehicles {

    // Providing implementation for start()
    public void start() {
        System.out.println("Car starts with key");
    }

    // Providing implementation for stop()
    public void stop() {
        System.out.println("Car stops using brake");
    }
}

// Main class
public class InterfaceExample {
    public static void main(String[] args) {
        // Cannot create object of interface
        // Vehicle v = new Vehicle(); → Not allowed
        // Create object of implementing class
        Vehicles v = new Cars();  // Upcasting
        // Calling implemented methods
        v.start();
        v.stop();
    }
}

