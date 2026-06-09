package ArrayDemo;

public class OneDArrayExample {
    public static void main(String[] args) {

        // Declare and create an array of size 5
        int[] numbers = new int[5];

        // Assign values to array elements using index (0 to 4)
        numbers[0] = 10;  // first element
        numbers[1] = 20;  // second element
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;  // last element

        // Access and print a single element
        System.out.println("First element: " + numbers[0]);

        // Print all elements using index
        System.out.println("All elements:");
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);
    }
}
