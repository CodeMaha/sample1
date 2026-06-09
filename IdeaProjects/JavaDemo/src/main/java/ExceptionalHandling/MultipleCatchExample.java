package ExceptionalHandling;

public class MultipleCatchExample {
    public static void main(String[] args) {

        try {
            int a=5;
            int b=0;
            int c=a/b;
            int arr[] = {1, 2, 3};
            // Possible Exceptions:
            // 1. ArrayIndexOutOfBoundsException
            // 2. ArithmeticException
            int result = arr[5] / 0;
        }
       //specfic exception has to be mentioned prior to to your general exception
        catch (ArithmeticException e) {
            // Handles divide by zero
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid index
            System.out.println("Array Index is invalid!");
        }
        catch (Exception e) {
            // Generic exception (fallback)
            System.out.println("Some other exception occurred!");
        }
        // specific exception followed by general exception
        System.out.println("Program continues");
    }
}
