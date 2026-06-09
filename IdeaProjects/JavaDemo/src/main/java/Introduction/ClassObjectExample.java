package Introduction;
class Student {
    int id;
    String name;
    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
    }
}
public class ClassObjectExample {
    public static void main(String[] args) {
        // Create object of Student class
        Student s1 = new Student();
        // Assign values
        s1.id = 101;
        s1.name = "testdata";
        // Call method
        s1.display();
    }
}

