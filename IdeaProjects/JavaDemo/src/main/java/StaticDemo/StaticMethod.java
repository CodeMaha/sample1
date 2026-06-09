package StaticDemo;

class MathUtils {
    // static method
    static int add(int a, int b) {
        return a + b;
    }
    static void printMessage() {
        System.out.println("This is a static method");
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        // Calling without object
        int result = MathUtils.add(10, 20);
        System.out.println("Sum = " + result);
        MathUtils.printMessage();
    }
}

/*
Belongs to class (not object).
Can be called using ClassName.methodName()
Can access only static variables directly
Cannot use non-static (instance) variables directly*/
