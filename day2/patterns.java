
public class patterns {

    public static void a5x5Matrix(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void printingNums(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println("");
        }
    }

    public static void LShapeStar(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void inverted_rightangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rightsided_inv_rightangledtringle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < n - i; k++) { // k <n-1 some other pattern
                System.out.print("*");   // give space it is inv triangle
            }
            System.out.println();
        }
    }

    public static void rightsided_rightangledtringle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void halfDiamond(int n) {
        // upper half (including middle row)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // lower half (excluding middle row)
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowTopTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                if (i == 1 || i == n || j == 1 || j == n - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void hollowBottomRightRigntangledTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                if (i == n || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void printinvnumsdownside(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                if (i == 1 || j == 1 || j == n - i + 1) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void LshapedPrintingAlphabets(int n ){
        char ch = 'A';
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("" + ch);
                ch++;
            }
            System.out.println();
        }
    }

    public static void uppertriangle(int n){
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n-i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print("*");
            }
            for(int l=0; l<i-1; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void revTriangle(int n){
        for(int i=0; i<n; i++){
            // spaces
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            // stars
            for (int k= 0; k<n-i; k++){
                System.out.print("*");
            }
            for (int l= 0; l<n-i-1; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void upper_lower_triangle(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<n-i; k++){
                System.out.print("*");
            }
            for(int l=0; l<n-i-1; l++){
                System.out.print("*");
            }
            System.out.println();
        }
        // ending singlepoint ablove is not considered here
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-i-2; j++){
                System.out.print(" ");
            }
            for (int k=0; k<i+2; k++){
                System.out.print("*");
            }
            for (int l=0; l<i+1; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void upperlowerShallowtriangle(int n){
        int cnt = 1;
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int k= 0; k<n-i; k++){
                if(i==0 || i==n || k==0 || k==n-i-1){
                    System.out.print(cnt+" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printX(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j || i + j == n - 1) {
                System.out.print(j+1);
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

    
    public static void main(String[] args) {
        // a5x5Matrix(5);
        // printingNums(4);
        // LShapeStar(5);
        // inverted_rightangle(5);
        // rightsided_inv_rightangledtringle(5);
        // rightsided_rightangledtringle(5);
        // halfDiamond(5);
        // hollowTopTriangle(5);
        // hollowBottomRightRigntangledTriangle(5);
        // printinvnumsdownside(5);
        // LshapedPrintingAlphabets(5);
        // uppertriangle(5);
        // revTriangle(5);
        // upper_lower_triangle(5);
        // upperlowerShallowtriangle(5);
        printX(9);
    }
}
