package Inheritance;
// Parent class
class Employee {
    void work() {
        System.out.println("Employee is working");
    }
}
// Child class
class Developer extends Employee {
    void code() {
        System.out.println("Developer writes code");
    }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Developer d = new Developer();
        d.work(); //  inherited from Employee
        d.code(); // own method
        /*
         Explanation:
         - Developer inherits methods from Employee
         - One parent → one child
         */
    }
}

