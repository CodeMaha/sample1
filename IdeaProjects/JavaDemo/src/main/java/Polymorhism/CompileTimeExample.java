package Polymorhism;
class Calculator {
    // Method 1
    int add(int a, int b) {
        return a + b;
    }
//try 2 pram float a float b

    // Method 2 (overloaded)
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class CompileTimeExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(10, 20));      // calls method 1
        System.out.println(calc.add(10, 20, 30));  // calls method 2
    }
}
