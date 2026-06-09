package Super;

class Parent {
    int value = 100;
}

class Child extends Parent {
    int value = 200;
    void display() {
        // Access child variable
        System.out.println("Child value: " + value);
        // Access parent variable using super
        System.out.println("Parent value: " + super.value);
        /*
         Explanation:
         - Both classes have variable 'value'
         - 'super.value' refers to parent class variable
         */
    }
}

public class SuperVariableExample {

    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
    }
}
