package Inheritance;
// p1, p2 ==>c1 Interface
// Parent class
class User {

    void login() {
        System.out.println("User logged in");
    }
}

// Child 1 //login browseprod
class Customer extends User {

    void browseProducts() {
        System.out.println("Browsing products");
    }
}

// Child 2 //login & manageusers
class Admin extends User {

    void manageUsers() {
        System.out.println("Managing users");
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {

        Customer c = new Customer();
        Admin a = new Admin();

        c.login();  // inherited
        c.browseProducts();

        a.login();  // inherited
        a.manageUsers();

        /*
         Explanation:
         - One parent (User)
         - Multiple child classes (Customer, Admin)
         */
    }
}
