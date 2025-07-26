
import java.util.Arrays;
import java.util.Scanner;

public class day6 {

    public static void alternateRowsColsInRevOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // start from last row and print every second row above it
        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // alt cols in rev order...
        System.out.println("\nAlternate columns in reverse order:");
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j -= 2) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void binaryConversionAnd1sCountInEachRow(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = matrix[i][j] & 1;
                if (matrix[i][j] == 1) {
                    count[i]++;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(count));
    }

    public static void sumalternaterowsEdgeElements(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < m; j++) {
                if (j == 0 || j == m - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.print(sum);
    }

    public static void flippingImage(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(matrix[i][j] ^ 1);
            }
        }
    }

    public static boolean isXMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == n - 1) {
                    if (matrix[i][j] == 0) {
                        return false;
                    }
                }else{
                    if(matrix[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void allRowsSorted(int[][] matrix){
        for(int[] row : matrix){
            // Arrays.sort(row);
            for(int i = 0; i< row.length - 1; i++){
                for(int j = 0; j < row.length - i - 1; j++){
                    if(row[j] > row[j+1]){
                        int temp = row[j];
                        row[j] = row[j+1];
                        row[j+1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void colEleSorted(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println(Arrays.deepToString(matrix));

        for(int j=0; j<m; j++){
            int[] temp = new int[n];
            for(int i = 0; i<n; i++){ 
                temp[i] = matrix[i][j];
            }
            Arrays.sort(temp);
            for(int i = 0; i<n; i++){ 
                matrix[i][j] = temp[i];
            }
        }
        System.out.println("final mat:" + Arrays.deepToString(matrix));
    }
    
    

    public static void main(String[] args) {
        System.out.println("Rows: ");
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        System.out.println("Columns: ");
        int cols = s.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        System.out.println("The matrix is: ");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // function calls strts here...
        // alternateRowsColsInRevOrder(matrix);
        // binaryConversionAnd1sCountInEachRow(matrix);
        // sumalternaterowsEdgeElements(matrix);
        // flippingImage(matrix);    
        // System.out.println(isXMatrix(matrix));
        // allRowsSorted(matrix);
        colEleSorted(matrix); // working..
        s.close();
    }
}
