package ArrayDemo;

public class ArrayTraversalExample {
    public static void main(String[] args) {

        // Create and initialize array
        int[] arr = {10, 20, 30, 40, 50};
        // Traversal using for loop
        System.out.println("Traversing array:");
        for (int i = 0; i < arr.length; i++) {
            // arr.length gives total number of elements
            System.out.println("Element at index " + i + " = " + arr[i]);
        }

        // Operation: Find sum of elements
        int sum = 0; // variable to store sum
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // adding each element to sum
        }
        System.out.println("Sum of elements: " + sum);

        // Operation: Find maximum value
        int max = arr[0]; // assume first element is max

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // update max if bigger value found
            }
        }
        System.out.println("Maximum value: " + max);
    }
}
