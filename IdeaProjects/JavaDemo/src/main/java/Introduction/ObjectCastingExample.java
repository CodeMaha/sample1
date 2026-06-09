package Introduction;

class Employee {
    void work() {
        System.out.println("Employee is working");
    }
}

class Manager extends Employee {
    void conductMeeting() {
        System.out.println("Manager is conducting a meeting");
    }
}

public class ObjectCastingExample {
    public static void main(String[] args) {

        // Upcasting (automatic)
        Employee emp = new Manager();
        emp.work();

        // Downcasting (manual)
        Manager mgr = (Manager) emp;
        mgr.conductMeeting();
    }
}

