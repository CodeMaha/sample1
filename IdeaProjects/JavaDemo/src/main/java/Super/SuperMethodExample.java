package Super;

class Parents {
    void show() {
        System.out.println("Parent method");
    }
}

class Childs extends Parents {
    void show() {
        System.out.println("Child method");
    }
    void display() {
        show();        // calls child method
        super.show();  // calls parent method

        /*
         Explanation:
         - same method exists in both classes
         - 'super.show()' calls parent version
         */
    }
}

public class SuperMethodExample {

    public static void main(String[] args) {
        Childs obj = new Childs();
        obj.display();
    }
}
