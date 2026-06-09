package Super;

class Parent1 {
    Parent1() {
        System.out.println("Parent constructor");
    }
}

class Child1 extends Parent {

    Child1() {
        // Calls parent constructor
        super();
        System.out.println("Child constructor");

        /*
         Explanation:
         - super() is used to call parent constructor
         - It is always called first
         */
    }
}

public class SuperConstructorExample {

    public static void main(String[] args) {
        Child1 obj = new Child1();
    }
}