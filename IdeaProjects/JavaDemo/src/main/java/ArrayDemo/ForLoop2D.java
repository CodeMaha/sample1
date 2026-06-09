package ArrayDemo;

public class ForLoop2D {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
// inner most loop is executed fully , outer most loop gets executed
        // Outer loop → rows i.len =3
        for (int i = 0; i < arr.length; i++) {
// row =0,1,2
            // Inner loop → columns a[0].len -> 3
            for (int j = 0; j < arr[i].length; j++) {
// 1 - [row=0]0,1,2
                System.out.print(arr[i][j] + " ");
            }
            // Move to next line after each row
            System.out.println();
        }
    }
}
