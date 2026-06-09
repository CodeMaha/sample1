package Polymorhism;

class Vehicle {
    void start() {
        System.out.println("Vehicle ");
    }
}

class Car extends Vehicle {
        void start() {
        System.out.println("Car - 4 wheels");
    }
}

public class RuntimeExample {
    public static void main(String[] args) {
        Vehicle v = new Car();  // Upcasting
        v.start();  // Calls Car method at runtime
    }
}

