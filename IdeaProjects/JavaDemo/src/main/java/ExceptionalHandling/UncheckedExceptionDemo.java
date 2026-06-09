package ExceptionalHandling;

public class UncheckedExceptionDemo {

    public static void main(String[] args) {
        // coding / logical error --
        // Example 1: ArithmeticException
        int a = 10;
        int b = 0;

        try {
            int result = a / b; // Division by zero
            System.out.println(result);
        }

      /*  catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }*/
        catch (Exception e) {
            System.out.println(e);
        }

        // Example 2: NullPointerException
        String str = null;


            System.out.println(str.length());
            // Trying to access method on null object

     /*   catch (Exception e) {
            System.out.println(e);
        }*/
      /*  catch (NullPointerException e) {
            System.out.println(e);
        }*/


        // Example 3: ArrayIndexOutOfBoundsException
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[5]);
            // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }

        System.out.println("Program completed");
    }
}

