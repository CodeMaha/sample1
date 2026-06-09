package Constructor;

class Employee {

    int empId;
    String empName;

    // Parameterized constructor
   /* Employee(int id, String name) {
        // Assigning values using parameters
        empId = id;
        empName = name;
    }*/
    //ambiguty
    Employee(int empId, String empName) {
        // Assigning values using parameters
        this.empId = empId;
        this.empName = empName;
    }
}

public class ParameterizedConstructorExample {

    public static void main(String[] args) {

        // Passing values while creating object
        Employee e1 = new Employee(101, "Ravi");

        System.out.println("Employee ID: " + e1.empId);
        System.out.println("Employee Name: " + e1.empName);

        /*
         Explanation:
         - Values are passed at the time of object creation
         - Constructor initializes variables directly
         */
    }
}
