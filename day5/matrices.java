
import java.util.*;

public class matrices {

    public static void diagonalDiff(int[][] matrix, int rows, int cols) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    sum1 += matrix[i][j];
                }
                if (i + j == rows - 1) {
                    sum2 += matrix[i][j];
                }
            }
        }
        System.out.println(sum2 - sum1);
    }

    public static void largestSmallestSum(int[][] matrix, int row, int col) {
        int s = 0, l = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] < s) {
                    s = matrix[i][j];
                }
                if (matrix[i][j] > l) {
                    l = matrix[i][j];
                }
            }
        }
        System.out.println(s + "+" + l + '=' + (s + l));
    }

    public static void firstDiaMax_secondDiaMin(int[][] matrix, int rows, int cols) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        System.out.println("initial values: " + max + " " + min);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
                if (i + j == rows - 1) {
                    if (matrix[i][j] < min) {
                        min = matrix[i][j];
                    }
                }
            }
        }
        System.out.println(max + "-" + min + "=" + (max - min));
    }

    public static void diagnalMin_restMax(int[][] matrix, int rows, int cols) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j || i + j == rows - 1) {
                    if (matrix[i][j] < min) {
                        min = matrix[i][j];
                    }
                } else {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
        }
        System.out.println("max, min values: " + max + " " + min + "max-min = " + (max - min));
    }

    public static void colTraversal(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][cols]);
        }
    }

    public static void rowReversal(int[][] matrix, int rows, int cols) {
        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;
            while (left < right) {
                int temp = row[right];
                row[right] = row[left];
                row[left] = temp;
                left++;
                right--;
            }
        }
        for (int row[] : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void colrev(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int col = 0; col < cols; col++) {
            int top = 0;
            int bottom = rows - 1;
            while (top < bottom) {
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
                top++;
                bottom--;
            }
        }
        for (int row[] : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static boolean isSparceMatrix(int[][] matrix) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }
        System.out.println("count of zeroes: " + count);
        return count > size / 2;
    }

    public static int sumOf4CornerElements(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int first = matrix[0][0];
        int second = matrix[0][cols - 1];
        int third = matrix[rows - 1][0];
        int fourth = matrix[rows - 1][cols - 1];
        return first + second + third + fourth;
    }

    public static void minMaxExceptCornerEles(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = matrix[i][j];
                if ((i == 0 && j == 0)
                        || (i == 0 && j == cols - 1)
                        || (i == rows - 1 && j == 0)
                        || (i == rows - 1 && j == cols - 1)) {
                            continue;
                }
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }
        System.out.println("max, min = " + max + " " + min);
    }

    public static boolean isToeplitzMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows-1; i++){
            for(int j=0; j<cols-1; j++){
                if(matrix[i][j] != matrix[i+1][j+1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Rows:");
            int rows = sc.nextInt();
            System.out.println("Cols:");
            int cols = sc.nextInt();
            int[][] matrix = new int[rows][cols];
            System.out.println("enter matrix: ");
            for (int i = 0; i < rows; i++) {
                // System.out.println(i + "th iteration outer");
                for (int j = 0; j < cols; j++) {
                    // System.out.println(j + "th iteration inner");
                    matrix[i][j] = sc.nextInt();
                }
            }
            for (int[] col : matrix) {
                System.out.println(Arrays.toString(col));
            }

            // diagonalDiff(matrix, rows, cols);
            // largestSmallestSum(matrix, rows, cols);
            // firstDiaMax_secondDiaMin(matrix, rows, cols);
            // diagnalMin_restMax(matrix, rows, cols);
            // colTraversal(matrix, rows, cols);   // working
            // rowReversal(matrix, rows, cols);
            // colrev(matrix);
            // System.out.println(isSparceMatrix(matrix));
            // System.out.println(sumOf4CornerElements(matrix));
            // minMaxExceptCornerEles(matrix);
            System.out.println(isToeplitzMatrix(matrix));
        }
    }
}
