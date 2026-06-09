package StaticDemo;

class Demo {

    static int num;

    // static block
    static {
        System.out.println("Static block executed");
        num = 100;
    }

    static void display() {
        System.out.println("Number = " + num);
    }
}

public class StaticBlock {
    public static void main(String[] args) {

        System.out.println("Main method started");

        Demo.display(); // triggers class loading

    }
}

/*
Used to initialize static variables
Executes only once when class loads
Runs before main() method*/
