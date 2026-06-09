package StaticDemo;

class Student {
    // static variable
    static String college = "ABC College";
    String name; // instance variable
    Student(String name) {
        this.name = name;
    }
    void display() {
        // Accessing static variable
        System.out.println(name + " studies in " + college);
    }
}

public class StaticVariableDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul");
        Student s2 = new Student("Anika");
        s1.display();
        s2.display();
        // Change static value (affects all objects)
        Student.college = "XYZ University";
        s1.display();
        s2.display();
    }
}


/*A static variable belongs to the class, not to objects.
It is shared among all objects.
If one object changes it → all objects see the updated value.*/

