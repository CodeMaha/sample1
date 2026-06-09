package Introduction;

class Students {

    // Instance Variable (belongs to object)
    int id;
    String name;

    void display() {
        // Local Variable (inside method)
        int marks = 90;
        System.out.println("ID: " + id);         // instance variable
        System.out.println("Name: " + name);     // instance variable
        System.out.println("Marks: " + marks);   // local variable
    }
}

public class VariableExample {

    public static void main(String[] args) {

        // Create object
        Students s1 = new Students();

        // Assign values to instance variables using object
        s1.id = 101;
        s1.name = "Arun";

        /*
         Cannot access local variable here
         int marks = 90 is inside display() method
         */
        // Call method
        s1.display();
    }
}


 /*
         Instance variables:
         - Declared inside class
         - Available to all methods of class
         - Stored in heap memory (object level)
         */

        /*
         Local variable:
         - Declared inside method
         - Accessible only within this method
         - Stored in stack memory
         */