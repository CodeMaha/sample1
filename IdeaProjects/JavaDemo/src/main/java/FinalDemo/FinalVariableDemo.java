package FinalDemo;

class FinalVariableDemo {
    public static void main(String[] args) {

        // final variable
        final int number = 10;

        System.out.println("Final value: " + number);

        //number = 20; // ERROR: cannot change final variable
    }
}

/*Value cannot be changed once assigned
Works like a constant
Must be initialized once only*/
