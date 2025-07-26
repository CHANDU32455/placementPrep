
import java.util.Scanner;

public class AmicablePair {

    public static boolean isMagicNum(int num) {
        int sum = num;
        while (sum > 9) {
            int temp = sum;
            sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
        }
        return (sum == 1);
    }

    public static int FactorsSum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter  number 1: ");
            int num1 = sc.nextInt();
            System.out.print("Enter  number 2: ");
            int num2 = sc.nextInt();
            int sum1 = FactorsSum(num1);
            int sum2 = FactorsSum(num2);
            if (sum1 == num2 && sum2 == num1) {
                System.out.println(num1 + " and " + num2 + " are amicable numbers.");
            } else {
                System.out.println(num1 + " and " + num2 + " are not amicable numbers.");
            }
        }

        
        if (isMagicNum(18)) {
            System.out.println("18 is a magic number.");
        } else {
            System.out.println("18 is not a magic number.");
        }
    }
}


/**
 * 
 * PS C:\Users\Chandu\projects\Placement_Preperation> javac AmicablePair.java; java AmicablePair; RlePair.class
Enter  number 1: 220
Enter  number 2: 284
220 and 284 are amicable numbers.
PS C:\Users\Chandu\projects\Placement_Preperation>


PS C:\Users\Chandu\projects\Placement_Preperation> javac AmicablePair.java; java AmicablePair; RlePair.class
Enter  number 1: 220
Enter  number 2: 284
10 is a magic number.
PS C:\Users\Chandu\projects\Placement_Preperation> javac AmicablePair.java; java AmicablePair; RlePair.class
Enter  number 2: 284
220 and 284 are amicable numbers.
18 is not a magic number.


 */