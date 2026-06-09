package ArrayDemo;

public class TwoDArrayExample {
    public static void main(String[] args) {

        // Declare and initialize 2D array (3 rows × 3 columns)
        int[][] matrix = {
                {1, 2, 3},   // row 0
                {4, 5, 6},   // row 1
                {7, 8, 9}    // row 2
        };

        // Access a specific element
        System.out.println("Element at [1][2]: " + matrix[1][2]);
        // row 1, column 2 → value = 6

        // Print all elements manually
        System.out.println("Matrix elements:");
        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        System.out.println(matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
        System.out.println(matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);
    }
}
