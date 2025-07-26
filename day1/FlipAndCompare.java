
import java.util.Scanner;

public class FlipAndCompare{

    public static int reverseNum(int num){
        int temp = num;
        int reversednum = 0;
        while(temp > 0){
            int dig = temp % 10;
            reversednum = reversednum*10 + dig;
            temp/=10;
        }
        return reversednum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num1rev = reverseNum(num1);
        int num2rev = reverseNum(num2);
        System.out.println(num1rev>num2rev ? num1rev : num2rev);
    }
}

/**
 * PS C:\Users\Chandu\projects\Placement_Preperation> javac FlipAndCompare.java; java FlipAndCompare; Remove-re.class
em FlipAndCompare.class                                                                               -Item Fl
123
321
PS C:\Users\Chandu\projects\Placement_Preperation> javac FlipAndCompare.java; java FlipAndCompare; Remove-Item FlipAndCompare.class
123
321
321
PS C:\Users\Chandu\projects\Placement_Preperation>


a, b = map(int, input().split())
a_rev = int(str(a)[::-1])
b_rev = int(str(b)[::-1])
print(max(a_rev, b_rev))

 */