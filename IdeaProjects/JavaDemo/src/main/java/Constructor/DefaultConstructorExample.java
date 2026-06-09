package Constructor;
class Student {
    int id;
    String name;
    float test;
    boolean result;
    // Default constructor (no parameters)
    Student() {
        // Assigning default values
        id = 100;
        name = "Default Name";
        test = 112.5F;
        result = true;
    }
}
public class DefaultConstructorExample {
    public static void main(String[] args) {
        // Creating object → default constructor is automatically called
        Student s1 = new Student();
        // Printing values assigned by constructor
        System.out.println("ID: " + s1.id);
        System.out.println("Name: " + s1.name);
        System.out.println("ID: " + s1.test);
        System.out.println("Name: " + s1.result);
        /*
         Explanation:
         - When object is created, default constructor runs automatically
         - It initializes instance variables with predefined values
         */
    }
}
