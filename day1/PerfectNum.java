
import java.util.Scanner;



public class PerfectNum {

    public static int IsPerfectNum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return (sum == num) ? 1 : 0;
    }

    public static void CheckPerfectNum(){
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter a num to check if it is a perfect num: ");
        int val = sc.nextInt();
        if (IsPerfectNum(val) == 1){
            System.out.println(val + " is a prfect number..");
        }else{
            System.out.println(val + " is not a prfect number..");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (IsPerfectNum(i) == 1) {
                System.out.println(i + " is a Perfect number");
            }
        }
        CheckPerfectNum();
    }
}



/**
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
7
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
6 is a Perfect number
28 is a Perfect number
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
28 is a Perfect number
496 is a Perfect number
8128 is a Perfect number
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
28 is a Perfect number
496 is a Perfect number
8128 is a Perfect number
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
28 is a Perfect number
496 is a Perfect number
8128 is a Perfect number
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
6 is a Perfect number
22
22is not a prfect number..
PS C:\Users\Chandu\projects\Placement_Preperation> javac PerfectNum.java; java PerfectNum; Remov.class
6 is a Perfect number
28 is a Perfect number
Enter a num to check if it is a perfect num:
6
6is a prfect number..
 */