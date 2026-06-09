package ArrayDemo;

public class ForEach2D {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Outer foreach → each row
        for (int[] row : arr) {
            // Inner foreach → each element in row
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println(); // new line after each row
        }
    }
}

