package FinalDemo;


class Parent {
    // final method
    final void show() {
        System.out.println("This is a final method");
    }
}

class Child extends Parent {
    //  ERROR: cannot override final method
   /* void show() {
        System.out.println("Trying to override");
    }*/
}

public class FinalMethodDemo {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}

/*A method declared as final cannot be overridden in a subclass
Used to restrict changing behavior*/

