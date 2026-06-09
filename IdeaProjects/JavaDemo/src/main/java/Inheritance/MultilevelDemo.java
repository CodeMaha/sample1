package Inheritance;

// Level 1 (Base class) //orgdetails
class Organization {

    void orgDetails() {
        System.out.println("Organization: XYZ Company");
    }
}

// Level 2 (inherits from Organization) //orgdetails & teamdetails
class Team extends Organization {

    void teamDetails() {
        System.out.println("Team: Automation Testing");
    }
}
//a-->b-->c
// Level 3 (inherits from Team) //org /team /leader
class Leader extends Team {

    void leaderDetails() {
        System.out.println("Leader: Senior QA Engineer");
    }
}

// Main class
public class MultilevelDemo {

    public static void main(String[] args) {

        // Creating object of lowest class
        Leader obj = new Leader();

        // Accessing methods from all levels
        obj.orgDetails();     // from Organization
        obj.teamDetails();    // from Team
        obj.leaderDetails();  // from Leader

        /*
         Explanation:
         - Leader inherits from Team
         - Team inherits from Organization
         - So Leader can access all methods

         Chain:
         Organization → Team → Leader
         */
    }
}

